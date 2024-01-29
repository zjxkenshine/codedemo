package com.kenshine.jxpath.model;

import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.xml.DocumentContainer;

import java.net.URL;

/**
 * @author kenshine
 */
public class Company {
    private Container locations = null;

    public Container getLocations(){
        if (locations == null){
            URL url = getClass().getResource("file/test01.xml");
            locations = new DocumentContainer(url);
        }
        return locations;
    }
 }