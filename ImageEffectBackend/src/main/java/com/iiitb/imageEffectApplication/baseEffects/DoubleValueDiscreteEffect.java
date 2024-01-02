package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
public interface DoubleValueDiscreteEffect extends PhotoEffect{

    //This interface is used for those filter functions where we need two integer parameters.
    void setParameterValues(int parameterValue1, int parameterValue2) throws IllegalParameterException;
}
