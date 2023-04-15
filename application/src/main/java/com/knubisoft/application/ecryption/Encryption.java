package com.knubisoft.application.ecryption;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public interface Encryption {

    byte[] encryptData(byte[] rawData, X509Certificate certificate);
    byte[] decryptData(byte[] rawData, PrivateKey decryptionKey);
}
