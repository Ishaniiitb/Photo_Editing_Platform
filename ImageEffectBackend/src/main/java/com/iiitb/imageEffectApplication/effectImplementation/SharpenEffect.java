package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SharpenInterface;

public class SharpenEffect implements SingleValueParameterizableEffect {
    private LoggingService loggingService;
    private float amount;

    public LoggingService getLoggingService() {
        return loggingService;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        System.out.println("Inside sharpen");
        Pixel[][] modifiedImage = SharpenInterface.applySharpen(image, this.amount);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Sharpen", String.valueOf(this.amount));
        return modifiedImage;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        this.amount = parameterValue;
    }
}
