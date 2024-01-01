package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.GrayscaleInterface;
import libraryInterfaces.Pixel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GrayScaleEffect implements PhotoEffect {

    private LoggingService loggingService;

    public LoggingService getLoggingService() {
        return this.loggingService;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        System.out.println("Inside Gray Scale");
        Pixel[][] modifiedImage = GrayscaleInterface.applyGrayscale(image);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Grayscale", "N/A");
        return modifiedImage;
    }
}
