package com.kenshine.web.demo02;

import com.kenshine.entity.demo02.Know;
import com.kenshine.entity.demo02.UserNode;
import com.kenshine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/22 10:07
 * @description：用户接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Description: 添加节点
     */
    @PostMapping("/add")
    public UserNode addUserNode(@RequestBody UserNode userNode) {
        return userService.create(userNode);
    }

    /**
     * @Description: 根据id删除
     */
    @PostMapping("/delete")
    public int delUserNodeById(@RequestParam(value = "id") Long id) {
        userService.deleteById(id);
        System.out.println(id);
        return 1;
    }

    /**
     * @Description: 根据id更新
     */
    @PostMapping("/update")
    public UserNode updateUserNodeByNode(@RequestBody UserNode userNode) {
        return userService.updateByNode(userNode);
    }

    @GetMapping("/{id}")
    public UserNode getUserNodeById(@PathVariable Long id) {
        Optional<UserNode> optionalUserNode =  userService.findById(id);
        if(optionalUserNode.isPresent()){
            return optionalUserNode.get();
        }else{
            return null;
        }
    }

    /**
     * 查找所有节点
     * @return
     */
    @GetMapping("/list")
    public List<UserNode> getUserNodeList() {
        return userService.findAll();
    }


    @PostMapping(path = "/addKnows")
    public Know addKnowsById(@RequestParam(value = "from") Long fromId, @RequestParam(value = "to") Long toId) {
        Optional<UserNode> fromOpt =  userService.findById(fromId);
        Optional<UserNode> toOpt =  userService.findById(toId);
        if(fromOpt.isPresent()&&toOpt.isPresent()){
            return userService.addIKnows(fromOpt.get(),toOpt.get());
        }else{
            return null;
        }
    }

    @PostMapping(path = "/delKnows")
    public String deleteKnowsByNodeId(@RequestParam(value = "from") Long fromId, @RequestParam(value = "to") Long toId) {
        Optional<UserNode> fromOpt =  userService.findById(fromId);
        Optional<UserNode> toOpt =  userService.findById(toId);
        if(fromOpt.isPresent()&&toOpt.isPresent()){
            userService.deleteKnowByNodeId(fromId,toId);
            return "ok";
        }else{
            return "false";
        }

    }

}
