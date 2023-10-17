package com.kenshine.clamshell;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.SplashScreen;

public class MockSplashScreen implements SplashScreen {

    @Override
    public void render(Context ctx) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void plug(Context plug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void unplug(Context plug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}