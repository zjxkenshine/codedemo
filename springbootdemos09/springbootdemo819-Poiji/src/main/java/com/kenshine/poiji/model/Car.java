package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCell;

public class Car extends Vehicle {

    @ExcelCell(2)
    private int nOfSeats;
}