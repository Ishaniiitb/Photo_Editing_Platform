package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.model.LogModel;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.ContrastInterface;
import libraryInterfaces.Pixel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContrastEffect implements SingleValueParameterizableEffect {   //contrast effect class that implements singke parameter interface

    private float amount;
    private LoggingService loggingService;

    public LoggingService getLoggingService() { //getter for logging service
        return loggingService;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        if(parameterValue < 0 || parameterValue > 100) //if parameter value is not in range
            throw new IllegalParameterException("Contrast parameter value outside the Range"); //throw exception
        this.amount = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //apply method
        Pixel[][] modifiedImage = ContrastInterface.applyContrast(image, this.amount);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Contrast", String.valueOf(this.amount));
        return modifiedImage;
    }
}
