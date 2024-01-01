package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.DoubleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import libraryInterfaces.FlipInterface;
import libraryInterfaces.Pixel;

public class FlipEffect implements DoubleValueDiscreteEffect {
    private int horizontalFlip;
    private int verticalFlip;
    private LoggingService loggingService;

    public LoggingService getLoggingService() {
        return loggingService;
    }

    @Override
    public void setParameterValues(int parameterValue1, int parameterValue2) throws IllegalParameterException {
        this.horizontalFlip = parameterValue1;
        this.verticalFlip = parameterValue2;
    }

    @Override
    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService loggingService) {
        System.out.println("Inside flip");
        Pixel[][] modifiedImage = FlipInterface.applyFlip(image, this.horizontalFlip, this.verticalFlip);
        this.loggingService = loggingService;
        String message;
        if(this.verticalFlip == 1 && this.horizontalFlip == 1)
            message = "Horizontal and Vertical Flip";
        else if(this.horizontalFlip == 1)
            message = "Horizontal Flip";
        else if(this.verticalFlip == 1)
            message = "Vertical Flip";
        else
            message = "None";
        this.loggingService.addLog(fileName, "Flip", message);
        return modifiedImage;
    }
}
