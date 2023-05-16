package com.knubisoft.application.encryption;

public interface Encryption {

    byte[] encryptData(byte[] rawData, byte[] certificate);
    byte[] decryptData(byte[] rawData, byte[] decryptionKey);
}
