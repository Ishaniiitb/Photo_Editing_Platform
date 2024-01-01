package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.BrightnessInterface;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.Pixel;

public class GaussianBlurEffect implements SingleValueParameterizableEffect {

    private LoggingService loggingService;
    private float radius;

    public LoggingService getLoggingService() {
        return loggingService;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        this.radius = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        System.out.println("Inside Gauss Blur");
        Pixel[][] modifiedImage = GaussianBlurInterface.applyGaussianBlur(image, this.radius);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Gaussian Blur", String.valueOf(this.radius));
        return modifiedImage;
    }
}
