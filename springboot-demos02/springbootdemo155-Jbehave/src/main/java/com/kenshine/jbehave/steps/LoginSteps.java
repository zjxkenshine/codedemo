package com.kenshine.jbehave.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 10:37
 * @description：登录步骤
 * @modified By：
 * @version: $
 */
@Component
public class LoginSteps {
    private String uid;

    private String password;


    @Given("uid is $uid and password is $password")
    public void init(String uid, String password) {
        this.uid = uid;
        this.password = password;
    }

    @When("i login")
    public void login(){
        //省略了登录业务
        System.out.println("登录成功："+ uid + "," + password);
    }

    @Then("i have role $role")
    public void check(String role) {
        //省略了鉴权业务
        System.out.println("拥有的权限是:"+role);
    }

}
