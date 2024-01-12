package com.kenshine.yasson;

import lombok.Data;

/**
 * 基本类型
 * @author kenshine
 */
@Data
public class Apartment {
    private boolean rented;
    private byte rooms;
    private int price;
    private long id;
    private float loan;
    private double area;
    private char district;
    private String ownerName;
}