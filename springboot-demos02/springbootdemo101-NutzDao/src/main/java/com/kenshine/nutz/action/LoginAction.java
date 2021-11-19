package com.kenshine.nutz.action;

import com.google.gson.Gson;
import com.kenshine.nutz.model.dto.QQDTO;
import com.kenshine.nutz.model.dto.QQOpenidDTO;
import com.kenshine.nutz.model.mapped.Role;
import com.kenshine.nutz.model.mapped.User;
import com.kenshine.nutz.properties.OAuthProperties;
import com.kenshine.nutz.utils.HttpsUtils;
import com.kenshine.nutz.utils.PasswordUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author kenshine
 */
@Controller
public class LoginAction {


    private Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @PostMapping("/login")
    public String login(String username, String password, boolean rememberMe, Model model) {
        //判断用户名和密码为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            model.addAttribute("msg", "用户名和密码不能为空！");
            return "login.html";
        }

        //开始登录
        //实际开发中，用户名和密码错误，不给出明确提示
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password, rememberMe));
        } catch (UnknownAccountException e) {//未知用户异常
            model.addAttribute("msg", "用户名错误！");
            return "login.html";
        } catch (LockedAccountException e) {//账户锁定
            model.addAttribute("msg", "账户被锁定！");
            return "login.html";
        } catch (CredentialsException e) {//用户密码错误异常
            model.addAttribute("msg", "用户密码错误！");
            return "login.html";
        } catch (Exception e) {
            model.addAttribute("msg", "其他异常！");
            return "login.html";
        }
        return "redirect:/index";
    }


    @Autowired
    private OAuthProperties oauth;


    //QQ登陆对外接口，只需将该接口放置html的a标签href中即可
    @GetMapping("/login/qq")
    public void loginQQ(HttpServletResponse response) {
        try {
            response.sendRedirect(oauth.getQQ().getCode_callback_uri() + //获取code码地址
                    "?client_id=" + oauth.getQQ().getClient_id()//appid
                    + "&state=" + UUID.randomUUID() + //这个说是防攻击的，就给个随机uuid吧
                    "&redirect_uri=" + oauth.getQQ().getRedirect_uri() +//这个很重要，这个是回调地址，即就收腾讯返回的code码
                    "&response_type=code");//授权模式，授权码模式
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Nutz dao
    @Autowired
    Dao dao;

    //接收回调地址带过来的code码
    @GetMapping("/authorize/qq")
    public String authorizeQQ(Map<String, String> msg, String code) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        params.put("redirect_uri", oauth.getQQ().getRedirect_uri());
        params.put("client_id", oauth.getQQ().getClient_id());
        params.put("client_secret", oauth.getQQ().getClient_secret());
        //获取access_token如：access_token=9724892714FDF1E3ED5A4C6D074AF9CB&expires_in=7776000&refresh_token=9E0DE422742ACCAB629A54B3BFEC61FF
        //TODO 其实整合NUTZ后，可以不使用HttpUtils工具类，并去掉pom中httpasyncclient、httpmime依赖，使用NUTZ自带HTTP工具
        String result = HttpsUtils.doGet(oauth.getQQ().getAccess_token_callback_uri(), params);
        //对拿到的数据进行切割字符串
        String[] strings = result.split("&");
        //切割好后放进map
        Map<String, String> reulsts = new HashMap<>();
        for (String str : strings) {
            String[] split = str.split("=");
            if (split.length > 1) {
                reulsts.put(split[0], split[1]);
            }
        }
        //到这里access_token已经处理好了
        //下一步获取openid，只有拿到openid才能拿到用户信息
        String openidContent = HttpsUtils.doGet(oauth.getQQ().getOpenid_callback_uri() + "?access_token=" + reulsts.get("access_token"));
        //接下来对openid进行处理
        //截取需要的那部分json字符串
        String openid = openidContent.substring(openidContent.indexOf("{"), openidContent.indexOf("}") + 1);
        Gson gson = new Gson();
        //将返回的openid转换成DTO
        QQOpenidDTO qqOpenidDTO = gson.fromJson(openid, QQOpenidDTO.class);
        User existUser = dao.fetch(User.class, Cnd.where("username", "=", qqOpenidDTO.getOpenid()));
        if (existUser == null) {
            params.clear();
            params.put("access_token", reulsts.get("access_token"));//设置access_token
            params.put("openid", qqOpenidDTO.getOpenid());//设置openid
            params.put("oauth_consumer_key", qqOpenidDTO.getClient_id());//设置appid
            String userInfo = HttpsUtils.doGet(oauth.getQQ().getUser_info_callback_uri(), params);
            QQDTO qqDTO = gson.fromJson(userInfo, QQDTO.class);//json转换成dto
            User user = new User();
            String salt = UUID.randomUUID().toString();
            user.setNickname(qqDTO.getNickname());
            user.setUsername(qqOpenidDTO.getOpenid());
            user.setPassword(PasswordUtils.getPassword(salt,qqOpenidDTO.getOpenid()));
            user.setSalt(salt);
            user.setAvailable(1);
            User insert = dao.insert(user);//向数据库插入数据
            ArrayList<Role> roles = new ArrayList<>();
            Role role = new Role();
            role.setId(1);//id = 1 是普通用户
            roles.add(role);
            insert.setRoles(roles);//将角色集合存入用户实体类
            dao.insertRelation(insert,"roles");//将用户和角色关联起来
            return QQLogin(msg, qqOpenidDTO);
        } else {
            return QQLogin(msg, qqOpenidDTO);
        }

        //这里拿用户昵称，作为用户名，openid作为密码（正常情况下，在开发时候用openid作为用户名，再自己定义个密码就可以了）
    }

    private String QQLogin(Map<String, String> msg, QQOpenidDTO qqOpenidDTO) {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(qqOpenidDTO.getOpenid(), qqOpenidDTO.getOpenid()));
        } catch (Exception e) {
            msg.put("msg", "第三方登陆失败,请联系管理！");
            logger.error(e.getMessage());
            return "login.html";
        }
        return "redirect:/index";
    }


}
