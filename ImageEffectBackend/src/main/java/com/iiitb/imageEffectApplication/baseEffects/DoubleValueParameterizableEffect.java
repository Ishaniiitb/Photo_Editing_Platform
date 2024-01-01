package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
public interface DoubleValueParameterizableEffect extends PhotoEffect{

    void setParameterValues(float parameterValue1, float parameterValue2) throws IllegalParameterException;
}
