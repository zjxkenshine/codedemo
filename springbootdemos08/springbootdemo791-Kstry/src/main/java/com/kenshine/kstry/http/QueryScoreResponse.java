package com.kenshine.kstry.http;

import com.kenshine.kstry.model.ScoreInfo;
import com.kenshine.kstry.model.Student;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.List;

/**
 * 出参
 * @author kenshine
 */
@Data
@FieldNameConstants(innerTypeName = "F")
public class QueryScoreResponse {

    private Student student;

    private List<ScoreInfo> scoreInfos;
}