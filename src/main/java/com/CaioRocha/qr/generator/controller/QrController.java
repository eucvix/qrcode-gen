package com.CaioRocha.qr.generator.controller;

import com.CaioRocha.qr.generator.dto.qrcode.QRGenreateResponse;
import com.CaioRocha.qr.generator.dto.qrcode.QrGenerateRequest;
import com.CaioRocha.qr.generator.service.QrGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/qrcode")


public class QrController {

    private final QrGeneratorService qrGeneratorService;

    public QrController(QrGeneratorService qrGeneratorService) {
        this.qrGeneratorService = qrGeneratorService;
    }

    public QrGeneratorService getQrGeneratorService() {
        return qrGeneratorService;
    }
    @PostMapping
    public ResponseEntity<QRGenreateResponse> generate(@RequestBody QrGenerateRequest request) throws IOException, WriterException {
    try {
        QRGenreateResponse response = this.qrGeneratorService.generateAndUpLoadQrCode(request.text());
                return ResponseEntity.ok(response);
    }catch (Exception e) {
        System.out.println(e);
        return ResponseEntity.internalServerError().build();
                }
         }
}



