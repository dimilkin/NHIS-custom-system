package com.nzis.ignatovsoft.services;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.nzis.ignatovsoft.Constants.pkcs11Path;


public class DigitalSignatureImpl {

    public DigitalSignatureImpl() {
    }

    public String signXml(String document) {
        try {
            return signedXml(document);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private String signedXml(String xmlDocument) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, KeyStoreException, IOException, CertificateException, UnrecoverableEntryException, ParserConfigurationException, SAXException, MarshalException, XMLSignatureException, TransformerException {

        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA256, null),
                Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null, null);

        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA256, null), Collections.singletonList(ref));

        // Load the KeyStore and get the signing key and certificate.
        Provider provider = Security.getProvider("SunPKCS11");
        provider = provider.configure(pkcs11Path);
        Security.addProvider(provider);

        char[] pin = {'1', '3', '1', '6'};
        KeyStore ks = KeyStore.getInstance("PKCS11-MY", provider);
        ks.load(null, pin);

        // Assuming there is only one entry in the KeyStore
        String alias = ks.aliases().nextElement();
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, pin);
        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(pin));
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
        PublicKey publicKey = cert.getPublicKey();

// Create the KeyInfo containing the X509Data.
        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(cert.getSubjectX500Principal().getName());
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        // Instantiate the document to be signed.
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xmlDocument.getBytes()));

// Create a DOMSignContext and specify the RSA PrivateKey and
// location of the resulting XMLSignature's parent element.
        DOMSignContext dsc = new DOMSignContext
                (keyEntry.getPrivateKey(), doc.getDocumentElement());

// Create the XMLSignature, but don't sign it yet.
        XMLSignature signature = fac.newXMLSignature(si, ki);

// Marshal, generate, and sign the enveloped signature.
        signature.sign(dsc);

        // Output the resulting document.
        StringWriter sw = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(sw));

        return sw.toString();
    }
}
