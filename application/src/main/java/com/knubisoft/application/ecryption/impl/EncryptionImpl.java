package com.knubisoft.application.ecryption.impl;

import com.knubisoft.application.ecryption.Encryption;
import lombok.SneakyThrows;
import org.bouncycastle.cms.CMSAlgorithm;
import org.bouncycastle.cms.CMSEnvelopedData;
import org.bouncycastle.cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSTypedData;
import org.bouncycastle.cms.KeyTransRecipientInformation;
import org.bouncycastle.cms.RecipientInformation;
import org.bouncycastle.cms.jcajce.JceCMSContentEncryptorBuilder;
import org.bouncycastle.cms.jcajce.JceKeyTransEnvelopedRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipient;
import org.bouncycastle.cms.jcajce.JceKeyTransRecipientInfoGenerator;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.OutputEncryptor;

import java.io.ByteArrayInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Collection;

import static java.util.Objects.isNull;

public class EncryptionImpl implements Encryption {

    @Override
    @SneakyThrows
    public byte[] encryptData(byte[] data, byte[] encryptionCertificateData) {
        if (isNull(data) || isNull(encryptionCertificateData)) {
            throw new RuntimeException("No data to encrypt");
        }
        Security.addProvider(new BouncyCastleProvider());
        X509Certificate encryptionCertificate = (X509Certificate) CertificateFactory.getInstance("X.509")
                .generateCertificate(new ByteArrayInputStream(encryptionCertificateData));
        CMSEnvelopedDataGenerator cmsEnvelopedDataGenerator = new CMSEnvelopedDataGenerator();
        JceKeyTransRecipientInfoGenerator jceKey = new JceKeyTransRecipientInfoGenerator(encryptionCertificate);
        cmsEnvelopedDataGenerator.addRecipientInfoGenerator(jceKey);
        CMSTypedData msg = new CMSProcessableByteArray(data);
        OutputEncryptor encryptor = new JceCMSContentEncryptorBuilder(CMSAlgorithm.AES128_CBC)
                .setProvider("BC").build();
        CMSEnvelopedData cmsEnvelopedData = cmsEnvelopedDataGenerator.generate(msg, encryptor);
        return cmsEnvelopedData.getEncoded();
    }


    @Override
    @SneakyThrows
    public byte[] decryptData(byte[] encryptedData, byte[] decryptionKeyData) {
        if (isNull(encryptedData) || isNull(decryptionKeyData)) {
            throw new RuntimeException("No data to decrypt");
        }
        Security.addProvider(new BouncyCastleProvider());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decryptionKeyData);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey decryptionKey = keyFactory.generatePrivate(keySpec);
        CMSEnvelopedData envelopedData = new CMSEnvelopedData(encryptedData);
        Collection<RecipientInformation> recipients = envelopedData.getRecipientInfos().getRecipients();
        KeyTransRecipientInformation recipientInfo = (KeyTransRecipientInformation) recipients.iterator().next();
        JceKeyTransRecipient recipient = new JceKeyTransEnvelopedRecipient(decryptionKey);
        return recipientInfo.getContent(recipient);
    }

}
