package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCell;

public abstract class Vehicle {

    @ExcelCell(0)
    protected String name;

    @ExcelCell(1)
    protected int year;
}

