package com.kenshine.converter.converter;

import com.github.liaochong.converter.annoation.Converter;
import com.kenshine.converter.bean.UserBO;
import com.kenshine.converter.bean.UserDO;

/**
 * @author kenshine
 * 用户转换器
 */
@Converter
public class UserConverter{

   public static UserBO convertDO2BO(UserDO user){
          UserBO result = new UserBO();
          result.setName(user.getName());
          return result;
   }
}