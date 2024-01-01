package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.DoubleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.HueSaturationInterface;
import libraryInterfaces.Pixel;

public class HueSaturationEffect implements DoubleValueParameterizableEffect {
    private LoggingService loggingService;
    private float hue;
    private float saturation;

    public LoggingService getLoggingService() {
        return loggingService;
    }

    @Override
    public void setParameterValues(float parameterValue1, float parameterValue2) throws IllegalParameterException {
        this.hue = parameterValue1;
        this.saturation = parameterValue2;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        System.out.println("Inside Hue Saturation");
        Pixel[][] modifiedImage = HueSaturationInterface.applyHueSaturation(image, this.saturation, this.hue);
        this.loggingService = loggingService;
        String message = "Hue = " + String.format("%.2f", this.hue) + ", Saturation = " + String.format("%.2f", this.saturation);
        this.loggingService.addLog(fileName, "Hue Saturation", message);
        return modifiedImage;
    }
}
