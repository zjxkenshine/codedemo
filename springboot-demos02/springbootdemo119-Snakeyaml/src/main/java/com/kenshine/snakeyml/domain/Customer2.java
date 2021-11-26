package com.kenshine.snakeyml.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 17:50
 * @description：
 * @modified By：
 * @version: $
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer2 {
    private String firstName;
    private String lastName;
    private int age;
    private List<Contact> contactDetails;
    private Address homeAddress;
}
