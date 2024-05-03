package com.kenshine.myexcel.model;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.github.liaochong.myexcel.core.annotation.ExcelModel;
import com.github.liaochong.myexcel.core.annotation.IgnoreColumn;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author by kenshine
 * @Classname ArtCrowd1
 * @Description 测试类
 * @Date 2024-05-03 9:27
 * @modified By：
 * @version: 1.0$
 */
@Data
@ExcelModel(sheetName = "艺术生")
public class ArtCrowd1 {
    @ExcelColumn(order = 0, title = "姓名")
    private String name;

    @ExcelColumn(order = 1, title = "年龄")
    private Integer age;

    @ExcelColumn(order = 2, title = "性别")
    private String gender;

    @ExcelColumn(order = 3,title = "绘画等级")
    private String paintingLevel;

    @ExcelColumn(order = 4, title = "是否会跳舞")
    private boolean dance;

    @ExcelColumn(order = 5, title = "考核时间", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime assessmentTime;

    @IgnoreColumn
    private String hobby;
}
