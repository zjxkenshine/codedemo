package com.kenshine.i18n.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 14:50
 * @description：获取国际化消息
 * @modified By：
 * @version: $
 */
@Component
public class LocaleMessage{

        @Resource
        private MessageSource messageSource;

        public String getMessage(String code){
            return this.getMessage(code,new Object[]{});
        }
        public String getMessage(String code,String defaultMessage){
            return this.getMessage(code,null,defaultMessage);
        }
        public String getMessage(String code,String defaultMessage,Locale locale){ return this.getMessage(code,null,defaultMessage,locale); }
        public String getMessage(String code,Locale locale){
            return this.getMessage(code,null,"成功",locale);
        }
        public String getMessage(String code,Object[] args){
            return this.getMessage(code,args,"成功");

        }
        public String getMessage(String code,Object[] args,Locale locale){
            return this.getMessage(code,args,code,locale);
        }
        public String getMessage(String code,Object[] args,String defaultMessage){
            return this.getMessage(code,args, defaultMessage,LocaleContextHolder.getLocale());
        }
        public String getMessage(String code,Object[]args,String defaultMessage,Locale locale){
            return messageSource.getMessage(code,args, defaultMessage,locale);
        }
}
