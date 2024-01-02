package com.iiitb.imageEffectApplication.baseEffects;

import com.iiitb.imageEffectApplication.exception.IllegalParameterException;

public interface SingleValueDiscreteEffect extends PhotoEffect {

    //This interface is used for those filter functions where we need one integer parameter.
    void setParameterValue(int parameterValue) throws IllegalParameterException;
}
