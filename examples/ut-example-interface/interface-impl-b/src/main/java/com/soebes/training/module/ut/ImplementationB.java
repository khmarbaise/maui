package com.soebes.training.module.ut;

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
