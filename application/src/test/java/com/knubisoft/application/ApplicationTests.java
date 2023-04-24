package com.knubisoft.application;

import com.knubisoft.application.ecryption.Encryption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private Encryption encryption;
    @Value("${keystore.password}")
    private char[] keystorePassword;
    @Value("${key.password}")
    private char[] keyPassword;
    private static final String original_data = "Hello, world!";
    private static final String certificateData_path = "src/main/resources/test.cer";
    private static final String privateKey_path = "src/main/resources/test.p12";
    private static final String alias = "baeldung";
    private static final String keyStoreInstance = "PKCS12";

    @Test
    @SneakyThrows
    public void testEncryptData() {
        byte[] certificateData = Files.readAllBytes(Paths.get(certificateData_path));
        byte[] encryptedData = encryption.encryptData(original_data.getBytes(), certificateData);
        Assertions.assertNotNull(encryptedData);
        Assertions.assertNotEquals(original_data.getBytes(), encryptedData);
    }

    @Test
    @SneakyThrows
    public void decryptDate() {
        byte[] certificateData = Files.readAllBytes(Paths.get(certificateData_path));
        byte[] privateKeyData = getPrivateKey();
        byte[] encryptedData = encryption.encryptData(original_data.getBytes(), certificateData);
        byte[] decryptedDataBytes = encryption.decryptData(encryptedData, privateKeyData);
        String decryptedData = new String(decryptedDataBytes);
        Assertions.assertNotNull(decryptedData);
        Assertions.assertEquals(original_data, decryptedData);
    }

    @SneakyThrows
    private byte[] getPrivateKey() {
        KeyStore keystore = KeyStore.getInstance(keyStoreInstance);
        keystore.load(Files.newInputStream(Paths.get(privateKey_path)), keystorePassword);
        PrivateKey key = (PrivateKey) keystore.getKey(alias, keyPassword);
        return key.getEncoded();
    }
}
