package com.kenshine.xades4j;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xades4j.XAdES4jException;
import xades4j.algorithms.EnvelopedSignatureTransform;
import xades4j.production.DataObjectReference;
import xades4j.production.SignedDataObjects;
import xades4j.production.XadesBesSigningProfile;
import xades4j.production.XadesSigner;
import xades4j.properties.DataObjectDesc;
import xades4j.properties.DataObjectFormatProperty;
import xades4j.providers.CertificateValidationProvider;
import xades4j.providers.KeyingDataProvider;
import xades4j.providers.impl.FileSystemKeyStoreKeyingDataProvider;
import xades4j.providers.impl.PKIXCertificateValidationProvider;
import xades4j.utils.FileSystemDirectoryCertStore;
import xades4j.utils.XadesProfileResolutionException;
import xades4j.verification.XAdESVerificationResult;
import xades4j.verification.XadesVerificationProfile;
import xades4j.verification.XadesVerifier;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;

/**
 * @author by kenshine
 * @Classname Xades4jTest
 * @Description 签名
 * @Date 2024-01-31 11:15
 * @modified By：
 * @version: 1.0$
 */
public class Xades4jTest {

    /**
     * Xades加密
     */
    @Test
    public void test01() throws Exception {
        Document doc = XmlHelper.getDocument("file\\test.xml");
        String keyPath = "";
        // 定义签名密钥/证书
        KeyingDataProvider kp = FileSystemKeyStoreKeyingDataProvider
                .builder("pkcs12", keyPath, new FirstCertificateSelector())
                .build();
        // 定义签名对象
        DataObjectDesc obj = new DataObjectReference("")
                .withTransform(new EnvelopedSignatureTransform())
                .withDataObjectFormat(new DataObjectFormatProperty("text/xml"));
        // 创建签名
        XadesSigner signer = new XadesBesSigningProfile(kp).newSigner();
        signer.sign(new SignedDataObjects(obj), doc.getDocumentElement());
    }

    /**
     * Xades校验
     */
    @Test
    public void test02() throws CertificateException, CRLException, NoSuchProviderException, NoSuchAlgorithmException, XadesProfileResolutionException, KeyStoreException {
        FileSystemDirectoryCertStore certStore = new FileSystemDirectoryCertStore("path/to/dir");
        KeyStore trustAnchors = KeyStore.getInstance("pkcs12");
        CertificateValidationProvider certValidator = PKIXCertificateValidationProvider
                .builder(trustAnchors)
                .checkRevocation(false)
                .intermediateCertStores(certStore.getStore())
                .build();

        XadesVerificationProfile p = new XadesVerificationProfile(certValidator);
        XadesVerifier v = p.newVerifier();
    }
}
