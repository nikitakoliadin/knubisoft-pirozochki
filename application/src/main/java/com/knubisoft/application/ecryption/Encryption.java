package com.knubisoft.application.ecryption;

public interface Encryption {

    byte[] encryptData(byte[] rawData, byte[] certificate);
    byte[] decryptData(byte[] rawData, byte[] decryptionKey);
}
