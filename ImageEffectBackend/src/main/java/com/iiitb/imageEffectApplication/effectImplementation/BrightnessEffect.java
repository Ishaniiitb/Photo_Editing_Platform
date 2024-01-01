package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.BrightnessInterface;
import libraryInterfaces.Pixel;
public class BrightnessEffect implements SingleValueParameterizableEffect {

    private LoggingService loggingService;
    private float amount;

    public LoggingService getLoggingService() {
        return loggingService;
    }

    @Override
    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        this.amount = parameterValue;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        System.out.println("Inside brightness");
        Pixel[][] modifiedImage = BrightnessInterface.applyBrightness(image, this.amount);
        this.loggingService = loggingService;
        this.loggingService.addLog(fileName, "Brightness", String.valueOf(this.amount));
        return modifiedImage;
    }
}
