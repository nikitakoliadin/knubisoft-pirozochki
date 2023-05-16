package com.knubisoft.application;

import com.knubisoft.application.ecryption.Encryption;
import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.PrivateKey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource("classpath:test-application.properties")
class ApplicationTests {

    @Autowired
    private Encryption encryption;
    @Value("${keystore.password}")
    private char[] keystorePassword;
    @Value("${key.password}")
    private char[] keyPassword;
    private static final String originalData = "Hello, world!";
    private static final String certificateDataPath = "src/test/resources/test.cer";
    private static final String privateKeyPath = "src/test/resources/test.p12";
    private static final String alias = "baeldung";
    private static final String keyStoreInstance = "PKCS12";

    @Test
    @SneakyThrows
    public void testEncryptData() {
        byte[] certificateData = Files.readAllBytes(Paths.get(certificateDataPath));
        byte[] encryptedData = encryption.encryptData(originalData.getBytes(), certificateData);
        assertNotNull(encryptedData);
        Assertions.assertNotEquals(originalData.getBytes(), encryptedData);
    }

    @Test
    @SneakyThrows
    public void testDecryptData() {
        byte[] certificateData = Files.readAllBytes(Paths.get(certificateDataPath));
        byte[] privateKeyData = getPrivateKey();
        byte[] encryptedData = encryption.encryptData(originalData.getBytes(), certificateData);
        assertNotNull(encryptedData);
        Assertions.assertNotEquals(originalData.getBytes(), encryptedData);
        byte[] decryptedDataBytes = encryption.decryptData(encryptedData, privateKeyData);
        String decryptedData = new String(decryptedDataBytes);
        assertNotNull(decryptedData);
        assertEquals(originalData, decryptedData);
    }

    @SneakyThrows
    private byte[] getPrivateKey() {
        KeyStore keystore = KeyStore.getInstance(keyStoreInstance);
        keystore.load(Files.newInputStream(Paths.get(privateKeyPath)), keystorePassword);
        PrivateKey key = (PrivateKey) keystore.getKey(alias, keyPassword);
        return key.getEncoded();
    }
}
