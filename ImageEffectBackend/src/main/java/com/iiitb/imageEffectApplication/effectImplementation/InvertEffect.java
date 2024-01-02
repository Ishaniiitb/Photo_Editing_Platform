package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.InvertInterface;
import libraryInterfaces.Pixel;

public class InvertEffect implements PhotoEffect {  //invert effect class that implements photo effect interface

    private LoggingService loggingService;

    public LoggingService getLoggingService() { //getter for logging service
        return loggingService;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //apply method
        System.out.println("Inside invert");
        Pixel[][] modifiedImage = InvertInterface.applyInvert(image);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Invert", "N/A");
        return modifiedImage;
    }
}
