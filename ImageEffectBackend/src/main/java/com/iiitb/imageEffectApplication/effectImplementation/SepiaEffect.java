package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SepiaInterface;


public class SepiaEffect implements PhotoEffect {   //sepia effect class that implements photo effect interface

    private LoggingService loggingService;

    public LoggingService getLoggingService() { //getter for logging service
        return loggingService;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //apply method
        System.out.println("Inside sepia");
        Pixel[][] modifiedImage = SepiaInterface.applySepia(image);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Sepia", "N/A");
        return modifiedImage;
    }
}
