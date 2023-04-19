package com.knubisoft.application;

import com.knubisoft.application.ecryption.Encryption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Encryption encryption;
    @Test
    void contextLoads() {
    }

    @Test
    @SneakyThrows
    public void testEncryptAndDecrypt() {
        // Read the certificate and private key from files
        byte[] certificateData = Files.readAllBytes(Paths.get("src/main/resources/test.cer"));
        byte[] privateKeyData = getPrivateKey();
        String originalData = "Hello, world!";
        byte[] originalDataBytes = originalData.getBytes();
        // Encrypt the data
        byte[] encryptedData = encryption.encryptData(originalDataBytes, certificateData);
        // Decrypt the data
        byte[] decryptedDataBytes = encryption.decryptData(encryptedData, privateKeyData);
        String decryptedData = new String(decryptedDataBytes);
        // Check that the decrypted data is the same as the original data
        Assertions.assertEquals(originalData, decryptedData);
    }

    private byte[] getPrivateKey() throws Exception {
        char[] keystorePassword = "test".toCharArray();
        char[] keyPassword = "test".toCharArray();
        KeyStore keystore = KeyStore.getInstance("PKCS12");
        keystore.load(Files.newInputStream(Paths.get("src/main/resources/test.p12")),
                keystorePassword);
        PrivateKey key = (PrivateKey) keystore.getKey("baeldung", keyPassword);
        return key.getEncoded();
    }
}
