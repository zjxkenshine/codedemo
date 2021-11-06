package com.kenshine.oval.annotations;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 9:53
 * @description：CPast验证
 * @modified By：
 * @version: $
 */
public class CPastCheck extends AbstractAnnotationCheck<CPast> {
    private static final long serialVersionUID=1L;

    private String dateFormat;



    public void configure(final CPast constraintAnnotation) {
        super.configure(constraintAnnotation);

        setDateFormat(constraintAnnotation.dateFormat());

    }



    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

        if(valueToValidate instanceof String) {
            try {
                Date date = sdf.parse((String) valueToValidate);

                return date.before(new Date());

            }catch (ParseException e) {
                e.printStackTrace();

                super.setMessage("日期格式错误,无法验证,请修改成正确格式.");

                return false;

            }

        }
        return false;
    }



    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat= dateFormat;

    }
}
