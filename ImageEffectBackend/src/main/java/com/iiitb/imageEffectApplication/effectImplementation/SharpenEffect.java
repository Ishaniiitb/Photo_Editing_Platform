package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.SharpenInterface;

public class SharpenEffect implements SingleValueParameterizableEffect {    //sharpen effect class that implements single parameter interface
    private LoggingService loggingService;
    private float amount;

    public LoggingService getLoggingService() { //getter for logging service
        return loggingService;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //apply method
        System.out.println("Inside sharpen");
        Pixel[][] modifiedImage = SharpenInterface.applySharpen(image, this.amount);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Sharpen", String.valueOf(this.amount));
        return modifiedImage;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {  // set parameter value
        if(parameterValue < 0 || parameterValue > 100) //if parameter value is not in range
            throw new IllegalParameterException("Sharpen parameter value outside the Range"); //throw exception
        this.amount = parameterValue;
    }
}
