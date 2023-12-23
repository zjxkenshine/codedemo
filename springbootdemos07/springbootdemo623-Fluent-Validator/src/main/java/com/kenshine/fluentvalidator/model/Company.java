package com.kenshine.fluentvalidator.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author kenshine
 * jsr-303支持
 */
@Data
public class Company {
    @NotEmpty
    @Pattern(regexp = "[0-9a-zA-Z\4e00-\u9fa5]+")
    private String name;

    @NotNull(message = "The establishTime must not be null")
    private Date establishTime;

    @NotNull
    @Size(min = 0, max = 10)
    @Valid
    private List<Department> departmentList;
}

