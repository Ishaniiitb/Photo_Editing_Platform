package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.BrightnessInterface;
import libraryInterfaces.Pixel;
public class BrightnessEffect implements SingleValueParameterizableEffect {  //Brightnesseffect class that implements single parameter effect interface

    private LoggingService loggingService;
    private float amount;

    public LoggingService getLoggingService() {
        return loggingService;
    }   //returns the logging service object

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {  //sets paramer value
        if(parameterValue>100 || parameterValue<0) throw new IllegalParameterException("Value out of Range")    //throws exception if values outside the range
        this.amount = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {   //applying the effect
        System.out.println("Inside brightness");
        Pixel[][] modifiedImage = BrightnessInterface.applyBrightness(image, this.amount);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Brightness", String.valueOf(this.amount));
        return modifiedImage;
    }
}
