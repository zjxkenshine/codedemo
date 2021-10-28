package com.kenshine.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 14:00
 * @description：用户查询条件
 * @modified By：
 * @version: $
 */
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserQuery {
    private Long idQuery;
    private String usernameQuery;
    private String passwordQuery;
    private String realnameQuery;
    private String genderQuery;
    private Integer ageQuery;
    private Integer minAgeQuery;
    private Integer maxAgeQuery;
    private String emailQuery;
    private Integer minUserPointQuery;
    private Integer maxUserPointQuery;
    private Byte userLevelQuery;
    private List<Long> idsQuery;
    private List<Integer> agesQuery;
    private List<Integer> userPointsQuery;
    private List<Byte> userLevelsQuery;
}
