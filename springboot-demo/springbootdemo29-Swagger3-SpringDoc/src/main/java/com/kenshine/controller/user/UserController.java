package com.kenshine.controller.user;

import com.kenshine.domain.CommonResult;
import com.kenshine.domain.User;
import com.kenshine.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 8:31
 * @description：用户Controller
 * @modified By：
 * @version: $
 */
@Tag(name = "用户管理", description = "用户的增删改查")
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @Operation(summary = "创建用户", description = "通过User对象保存用户")
    @Parameters(value = {
            @Parameter(name = "id", description = "用户id", required = true, example = "1",
                    schema = @Schema(implementation = Long.class), in = ParameterIn.QUERY),
            @Parameter(name = "username", description = "用户名", required = true, example = "admin",
                    schema = @Schema(implementation = String.class), in = ParameterIn.QUERY),
            @Parameter(name = "password", description = "密码", required = true, example = "admin",
                    schema = @Schema(implementation = String.class), in = ParameterIn.QUERY)})
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "保存用户成功"),
            @ApiResponse(responseCode = "400", description = "无效参数")})
    @PostMapping("/save")
    public CommonResult<User> saveUser(@Parameter(hidden = true) User user) {
        return userService.saveUser(user);
    }

    @Operation(summary = "查询所有用户", description = "查询所有用户")
    @ApiResponse(responseCode = "200", description = "查询所有用户成功")
    @GetMapping("/findAll")
    public CommonResult<List<User>> findUserAll() {
        return userService.findUserAll();
    }

    @Operation(summary = "根据id查询用户", description = "查询指定id用户")
    @Parameter(name = "id", description = "用户id", required = true, example = "1")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "查询指定id用户成功"),
            @ApiResponse(responseCode = "400", description = "无效参数")})
    @GetMapping("/findById/{id}")
    public CommonResult<User> findUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    @Operation(summary = "根据id更新用户", description = "更新指定id用户")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "更新指定id用户成功"),
            @ApiResponse(responseCode = "400", description = "无效参数"),
            @ApiResponse(responseCode = "404", description = "用户不存在")})
    @PutMapping("/updateById")
    public CommonResult<User> updateUserById(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "用户参数",
            required = true, content = @Content(schema = @Schema(implementation = User.class))) @RequestBody User user) {
        return userService.updateUserById(user);
    }

    @Operation(summary = "根据id删除用户", description = "删除指定id的用户")
    @Parameter(name = "id", description = "用户id", required = true, example = "1")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "删除指定id用户成功"),
            @ApiResponse(responseCode = "400", description = "无效参数"),
            @ApiResponse(responseCode = "404", description = "用户不存在")})
    @DeleteMapping("/deleteById/{id}")
    public CommonResult<User> deleteUserById(@PathVariable(value = "id") Long id) {
        return userService.deleteUserById(id);
    }

    @Operation(summary = "删除所有用户", description = "删除所有用户")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "删除所有用户成功"),
            @ApiResponse(responseCode = "404", description = "用户不存在")})
    @DeleteMapping("/deleteAll")
    public CommonResult<List<User>> deleteUserAll() {
        return userService.deleteUserAll();
    }

}
