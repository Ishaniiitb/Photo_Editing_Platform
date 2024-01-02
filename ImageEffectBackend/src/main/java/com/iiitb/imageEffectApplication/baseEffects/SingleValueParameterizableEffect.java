package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

// Could be things like changing hue, saturation, brightness, contrast (i.e. only single parameter)
public interface SingleValueParameterizableEffect extends PhotoEffect {

    //This interface is used for those filter functions where we need one floating parameter.
    void setParameterValue(float parameterValue) throws IllegalParameterException;
}
