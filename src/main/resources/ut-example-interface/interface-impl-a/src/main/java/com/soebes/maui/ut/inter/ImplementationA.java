package com.soebes.maui.ut.inter;

import com.soebes.maui.ut.inter.IFunction;

public class ImplementationA implements IFunction {

    @Override
    public boolean function(String parameter1) {
        if (parameter1.startsWith("function1")) {
            return true;
        }
        return false;
    }

}
