package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.Pixel;
import libraryInterfaces.RotationInterface;

public class RotationEffect implements SingleValueDiscreteEffect {  //rotation effect class that implements single value discrete effect interface
    private LoggingService loggingService;
    private int amount;

    public LoggingService getLoggingService() { //getter for logging service
        return loggingService;
    }

    @Override
    public void setParameterValue(int parameterValue) throws IllegalParameterException {    // set parameter value
        if(parameterValue < 0 || parameterValue > 3) //if parameter value is not in range
            throw new IllegalParameterException("Rotation parameter value outside the Range"); //throw exception
        this.amount = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //apply method
        System.out.println("Inside Rotation");
        Pixel[][] modifiedImage = RotationInterface.applyRotation(image, this.amount);
        this.loggingService = loggingService;
        int angle = this.amount * 90;
        this.loggingService.addLog(fileName, "Rotation", String.valueOf(angle) + " Degrees");
        return modifiedImage;
    }
}
