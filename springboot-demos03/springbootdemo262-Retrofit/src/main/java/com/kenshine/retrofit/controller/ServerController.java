package com.kenshine.retrofit.controller;

import com.kenshine.retrofit.domain.TestEntity;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Body;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 23:58
 * @description： 模拟远程Http服务
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/server")
public class ServerController {
    @GetMapping("/test01")
    public void test01(){
        System.out.println("调用了Test01");
    }

    @PostMapping("/postList")
    public List<TestEntity> test02(@RequestBody TestEntity testEntity){
        System.out.println("调用了Test02");
        System.out.println(testEntity);
        return  Arrays.asList(testEntity,new TestEntity(1,2
        ),new TestEntity(2,3));
    }

    @GetMapping("/entity/{id}")
    public List<TestEntity> test03(@PathVariable Long id){
        System.out.println("调用了Test03,获取到的id为"+id);
        return  Arrays.asList(new TestEntity(1,2
        ),new TestEntity(2,3));
    }

    @GetMapping("/getList")
    public List<TestEntity> test04(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        System.out.println("调用了Test04,"+pageNum+"," + pageSize);
        return  Arrays.asList(new TestEntity(pageNum,pageSize
        ),new TestEntity(2,3));
    }

    @GetMapping("/getHeader")
    public void test04(HttpServletRequest request){
        System.out.println(request.getHeader("Accept-Language"));
    }
}
