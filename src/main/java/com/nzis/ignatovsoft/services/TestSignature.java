package com.nzis.ignatovsoft.services;

import java.io.IOException;
import java.security.*;
import java.util.Collections;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.*;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.*;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class TestSignature {

    XMLSignatureFactory sigFactory = XMLSignatureFactory.getInstance("DOM");
    PrivateKey privateKey;
    PublicKey publicKey;

    public TestSignature() throws NoSuchAlgorithmException {
    }

    private void generateKey () throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        PrivateKey privateKey = kp.getPrivate();
        PublicKey publicKey = kp.getPublic();
    }

    private void createXmlDocument () throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse("path/to/your/xmlfile.xml");

    }

    private void createSigningFactory () throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {

        Reference ref = sigFactory.newReference
                ("", sigFactory.newDigestMethod(DigestMethod.SHA256, null),
                        Collections.singletonList(sigFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)),
                        null, null);

        SignedInfo si = sigFactory.newSignedInfo
                (sigFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE,
                                (C14NMethodParameterSpec) null),
                        sigFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                        Collections.singletonList(ref));

    }

    private void prepareKeyinfo () throws KeyException {
        KeyInfoFactory kif = sigFactory.getKeyInfoFactory();
        KeyValue keyValue = kif.newKeyValue(publicKey);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(keyValue));
    }

    private void signDocument (KeyInfo ki, SignedInfo si, Document doc) throws MarshalException, XMLSignatureException {
        XMLSignature signature = sigFactory.newXMLSignature(si, ki);

        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());
        signature.sign(dsc);

    }






}



