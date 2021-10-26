package com.kenshine.validator;

import com.kenshine.annotation.Rank;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:07
 * @description：自定义Rank校验器
 * @modified By：
 * @version: $
 */
public class RankValidator implements ConstraintValidator<Rank, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        HashSet<String> ranks = new HashSet<>();
        ranks.add("无段位");
        ranks.add("青铜");
        ranks.add("白银");
        ranks.add("黄金");
        ranks.add("铂金");
        ranks.add("钻石");
        // 段位必须为无段位、青铜、白银、黄金、铂金、钻石之一
        return ranks.contains(value);
    }

}
