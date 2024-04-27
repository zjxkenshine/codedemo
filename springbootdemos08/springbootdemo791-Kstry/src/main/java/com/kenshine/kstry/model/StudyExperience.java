package com.kenshine.kstry.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author by kenshine
 * @Classname StudyExperience
 * @Description 学年信息
 * @Date 2024-04-27 9:03
 * @modified By：
 * @version: 1.0$
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudyExperience {
    private Long studentId;
    private Long classId;
    private String studyYear;
}
