package com.kenshine.web;

import com.kenshine.domain.User;
import com.kenshine.groups.AddUserGroup;
import com.kenshine.groups.ModifyUserGroup;
import com.kenshine.response.CommonResult;
import com.kenshine.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 14:18
 * @description：用户校验
 * @modified By：
 * @version: $
 */
@RequestMapping("/user")
@RestController
public class UserController {

    /**
     * 校验请求体 测试
     * @param user
     * @return
     */
    @PostMapping("/save")
    public CommonResult<User> saveUser(@RequestBody @Valid User user) {
        return CommonResult.ok("保存用户成功", user);
    }

    /**
     * 校验请求参数 path
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public CommonResult<User>
    getUserById(@Valid @PathVariable(value = "id") @Min(value = 1, message = "id不能小于1") Long id) {

        User user = new User(id, "kenshine", "Aa123456", 25, "kenshine@xxx.com", "黄金");
        return CommonResult.ok("根据id查询用户成功", user);

    }

    /**
     * 校验请求参数 query
     * @param username 用户名
     * @return
     */
    @DeleteMapping("/delete")
    public CommonResult<User> deleteByUsername(@Valid @RequestParam(value = "username") @Size(min = 6, max = 20, message = "用户名长度不在指定范围内") String username) {

        User user = new User(1L, username, "A123456", 25, "kenshine@xxx.com", "黄金");
        return CommonResult.ok("根据用户名删除用户成功", user);

    }


    /**
     * 通过@Validated和@Valid注解组合使用不仅可以校验Controller中的参数，还可以校验任何Spring组件中的参数
     *
     */
    @Resource
    private UserService userService;

    @PutMapping("/update")
    public CommonResult<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 编程式校验 使用validator bean
     */
    @Resource
    private Validator validator;

    @PostMapping("/insert")
    public CommonResult<User> insertUser(@RequestBody User user) {
        if (!validator.validate(user).isEmpty()) {
            throw new ConstraintViolationException(validator.validate(user));
        }
        return CommonResult.ok("添加用户成功", user);
    }


    /**
     * 分组校验测试
     */
    @PostMapping("/add")
    public CommonResult<User> addUser(@RequestBody @Validated(value = AddUserGroup.class) User user) {
        return CommonResult.ok("新增用户成功", user);
    }

    @PutMapping("/modify")
    public CommonResult<User> modifyUser(@RequestBody @Validated(value = ModifyUserGroup.class) User user) {
        return CommonResult.ok("修改用户成功", user);
    }





}
