package com.soebes.maui.ut.inter;

import com.soebes.maui.ut.inter.IFunction;

public class ImplementationB implements IFunction {

    @Override
    public boolean function(String parameter1) {
        if (parameter1.startsWith("func")) {
            String s = parameter1.substring(4);
            if (s.startsWith("tion1")) {
                return true;
            }
        }
        return false;
    }

}
