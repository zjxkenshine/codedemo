package com.kenshine.clamshell;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.InputController;

import java.util.regex.Pattern;

public class MockInputController implements InputController {

    @Override
    public boolean handle(Context ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pattern respondsTo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getExpectedInputs() {
        return new String[0];
    }


    @Override
    public Boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void plug(Context plug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}