package com.nzis.ignatovsoft.services;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;


public class DocumentSignerImpl {


    private static String pkcs11Path = "src/main/resources/configs/pkcs11.cfg";

    public static String signXML(String xmlData) {

        try {
            Provider provider = Security.getProvider("SunPKCS11");
            provider = provider.configure(pkcs11Path);
            Security.addProvider(provider);
            Provider[] providers = Security.getProviders();

            char[] pin = {'1', '3', '1', '6'};
            KeyStore keyStore = KeyStore.getInstance("PKCS11-MY", provider);
            keyStore.load(null, pin);


            // Assuming there is only one entry in the KeyStore
            String alias = keyStore.aliases().nextElement();
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, pin);
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);
            PublicKey publicKey = cert.getPublicKey();

            // Setup XML Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder builder = dbf.newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));

            // Create a DOM XMLSignatureFactory that will be used to generate the enveloped signature
            XMLSignatureFactory sigFactory = XMLSignatureFactory.getInstance("DOM");

            // Create a Reference to the enveloped document
            Reference ref = sigFactory.newReference("", sigFactory.newDigestMethod(DigestMethod.SHA256, null),
                    Collections.singletonList(sigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                    null, null);

            // Create the SignedInfo
            SignedInfo signedInfo = sigFactory.newSignedInfo(sigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                            (C14NMethodParameterSpec) null),
                    sigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                    Collections.singletonList(ref));

            // Load the KeyInfo
            KeyInfoFactory kif = sigFactory.getKeyInfoFactory();
            KeyInfo ki = kif.newKeyInfo(Collections.singletonList(kif.newX509Data(Collections.singletonList(cert))));

            // Create a DOMSignContext and specify the RSA PrivateKey and location of the resulting XMLSignature's parent element
            DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());

            // Create the XMLSignature, but don't sign it yet
            XMLSignature signature = sigFactory.newXMLSignature(signedInfo, ki);

            // Marshal, generate, and sign the enveloped signature
            signature.sign(dsc);

            // Output the resulting document
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer trans = tf.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter writer = new StringWriter();
            trans.transform(new DOMSource(doc), new StreamResult(writer));

            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}



