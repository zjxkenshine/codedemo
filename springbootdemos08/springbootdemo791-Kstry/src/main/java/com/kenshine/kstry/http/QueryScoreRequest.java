package com.kenshine.kstry.http;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * 入参
 * @author kenshine
 */
@Data
@FieldNameConstants(innerTypeName = "F")
public class QueryScoreRequest {

    private Long studentId;

    private boolean needScore;
}