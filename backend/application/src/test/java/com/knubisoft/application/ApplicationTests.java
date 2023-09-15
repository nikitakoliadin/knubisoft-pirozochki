package com.knubisoft.application;

import com.knubisoft.application.encryption.Encryption;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
class ApplicationTests {

    private static final String ORIGINAL_DATA = "Hello, world!";
    private static final String CERTIFICATE_DATA_PATH = "src/test/resources/test.cer";
    private static final String PRIVATE_KEY_PATH = "src/test/resources/test.p12";
    private static final String ALIAS = "baeldung";
    private static final String KEY_STORE_INSTANCE = "PKCS12";
    @Autowired
    private Encryption encryption;
    @Value("${keystore.password}")
    private char[] keystorePassword;
    @Value("${key.password}")
    private char[] keyPassword;

    @Test
    @SneakyThrows
    public void testEncryptData() {
        byte[] certificateData = Files.readAllBytes(Paths.get(CERTIFICATE_DATA_PATH));
        byte[] encryptedData = encryption.encryptData(ORIGINAL_DATA.getBytes(), certificateData);
        assertNotNull(encryptedData);
        Assertions.assertNotEquals(ORIGINAL_DATA.getBytes(), encryptedData);
    }

    @Test
    @SneakyThrows
    public void testDecryptData() {
        byte[] certificateData = Files.readAllBytes(Paths.get(CERTIFICATE_DATA_PATH));
        byte[] privateKeyData = getPrivateKey();
        byte[] encryptedData = encryption.encryptData(ORIGINAL_DATA.getBytes(), certificateData);
        assertNotNull(encryptedData);
        Assertions.assertNotEquals(ORIGINAL_DATA.getBytes(), encryptedData);
        byte[] decryptedDataBytes = encryption.decryptData(encryptedData, privateKeyData);
        String decryptedData = new String(decryptedDataBytes);
        assertNotNull(decryptedData);
        assertEquals(ORIGINAL_DATA, decryptedData);
    }

    @SneakyThrows
    private byte[] getPrivateKey() {
        KeyStore keystore = KeyStore.getInstance(KEY_STORE_INSTANCE);
        keystore.load(Files.newInputStream(Paths.get(PRIVATE_KEY_PATH)), keystorePassword);
        PrivateKey key = (PrivateKey) keystore.getKey(ALIAS, keyPassword);
        return key.getEncoded();
    }
}
