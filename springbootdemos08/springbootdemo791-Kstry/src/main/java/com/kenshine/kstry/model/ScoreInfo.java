package com.kenshine.kstry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname ScoreInfo
 * @Description 分数信息
 * @Date 2024-04-27 9:03
 * @modified By：
 * @version: 1.0$
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScoreInfo {
    private int score;
    private Long studentId;
    private String studyYear;
    private String course;
    private Long classId;
    private ClassInfo classInfo;
}
