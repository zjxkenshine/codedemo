package com.kenshine.jcodemodel.gen;

public class Test06 {

    public String getGenderName(int sex) {
        switch (sex) {
            case  1 :
            {
                return "Female";
            }
            case  0 :
            default:
            {
                return "Male";
            }
        }
    }
}
