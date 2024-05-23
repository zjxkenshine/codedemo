package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelUnknownCells;
import lombok.Data;

import java.util.Map;

/**
 * 未知字段处理
 * @author kenshine
 */
@Data
public class MusicTrack {

    @ExcelCellName("ID")
    private String employeeId;

    @ExcelCellName("AUTHOR")
    private String author;

    @ExcelCellName("NAME")
    private String name;

    @ExcelUnknownCells
    private Map<String, String> unknownCells;

}