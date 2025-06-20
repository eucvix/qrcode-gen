package com.CaioRocha.qr.generator.ports;

public interface StoragePort {
    String uploadFile(byte[] pngQrCodeData, String string, String contentType);
}
