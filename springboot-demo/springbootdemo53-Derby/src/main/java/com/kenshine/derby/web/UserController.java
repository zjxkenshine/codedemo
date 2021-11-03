package com.kenshine.derby.web;

import com.alibaba.fastjson.JSONObject;
import com.kenshine.derby.entity.User;
import com.kenshine.derby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/3 22:18
 * @description：用户接口
 * @modified By：
 * @version: $
 *
 * druid地址 localhost:8080/druid
 */
@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello";
	}
	/**
	 * 测试插入
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(){
		User u = new User();
		int i = (int) (Math.random()*100)+100;
		u.setId(String.valueOf(i));
		u.setUserName("kenshine"+i);
		this.userService.insert(u);
		return "success";
	}
	/**
	 * 测试分页
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	public String queryPage(Integer pageNum,String userName){
		List<User> list = this.userService.queryByPage(userName != null ?userName:null,
				pageNum == null ? 1 : pageNum, 2);
		return JSONObject.toJSONString(list);
	}
	
	/**
	 * 测试mapper.xml
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public String query(String userName){
		List<User> list = this.userService.query(userName != null ?userName:null);
		return JSONObject.toJSONString(list);
	}

}
