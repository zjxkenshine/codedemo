package com.kenshine.poiji.model;

import com.poiji.annotation.ExcelCellsJoinedByName;
import lombok.Data;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

/**
 * @author Administrator
 * 多列映射到一个字段
 */
@Data
public class Album {

    @ExcelCellsJoinedByName(expression = "Artist")
    private MultiValuedMap<String, String> artists = new ArrayListValuedHashMap<>();

    @ExcelCellsJoinedByName(expression = "Track[0-9]+")
    private MultiValuedMap<String, String> tracks = new ArrayListValuedHashMap<>();

}