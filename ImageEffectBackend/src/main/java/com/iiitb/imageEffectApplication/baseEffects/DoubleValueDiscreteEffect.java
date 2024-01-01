package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
public interface DoubleValueDiscreteEffect extends PhotoEffect{

    void setParameterValues(int parameterValue1, int parameterValue2) throws IllegalParameterException;
}
