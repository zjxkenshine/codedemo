package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelCellRange;
import lombok.Data;

/**
 * @author kenshine
 *
 */
@Data
public class PersonCreditInfo {

    @ExcelCellName("No.")
    private Integer no;

    @ExcelCellRange
    private PersonInfo personInfo;

    @ExcelCellRange
    private CardInfo cardInfo;

    @Data
    public static class PersonInfo {
        @ExcelCellName("Name")
        private String name;
        @ExcelCellName("Age")
        private Integer age;
        @ExcelCellName("City")
        private String city;
        @ExcelCellName("State")
        private String state;
        @ExcelCellName("Zip Code")
        private String zipCode;
    }

    @Data
    public static class CardInfo {
        @ExcelCellName("Card Type")
        private String type;
        @ExcelCellName("Last 4 Digits")
        private String last4Digits;
        @ExcelCellName("Expiration Date")
        private String expirationDate;
    }
}