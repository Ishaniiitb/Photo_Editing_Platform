package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
public interface DoubleValueParameterizableEffect extends PhotoEffect{

    //This interface is used for those filter functions where we need two floating parameters.
    void setParameterValues(float parameterValue1, float parameterValue2) throws IllegalParameterException;
}
