package com.kenshine.binder.web;

import com.kenshine.binder.domain.User;
import com.kenshine.binder.validator.EmailValidator;
import com.kenshine.binder.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 14:01
 * @description：测试校验
 * @modified By：
 * @version: 1.0$
 */
@Controller
public class ValidatorController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private EmailValidator emailValidator;

    /**
     * 接收参数,自定义编辑器
     */
    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(userValidator, emailValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //setLenient用于设置Calendar是否宽松解析字符串，如果为false，则严格解析；默认为true，宽松解析
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthday", new CustomDateEditor(dateFormat, true));
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return Objects.requireNonNull(result.getFieldError()).getDefaultMessage();
        }
        System.out.println("Name:" + user.getName());
        System.out.println("Email:" + user.getEmail());
        System.out.println("Date of Birth:" + user.getBirthday());
        return "success";
    }

}
