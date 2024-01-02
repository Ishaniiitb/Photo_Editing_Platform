package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.BrightnessInterface;
import libraryInterfaces.GaussianBlurInterface;
import libraryInterfaces.Pixel;

public class GaussianBlurEffect implements SingleValueParameterizableEffect {   //gaussian blur effect class that implements single parameter interface

    private LoggingService loggingService;
    private float radius;

    public LoggingService getLoggingService() { //getter for logging service
        return loggingService;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if(parameterValue < 0 || parameterValue > 100) //if parameter value is not in range
            throw new IllegalParameterException("Gaussian Blur radius value outside the Range"); //throw exception
        this.radius = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //apply method
        System.out.println("Inside Gauss Blur");
        Pixel[][] modifiedImage = GaussianBlurInterface.applyGaussianBlur(image, this.radius);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Gaussian Blur", String.valueOf(this.radius));
        return modifiedImage;
    }
}
