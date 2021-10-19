package com.kenshine.error.handler;

import com.kenshine.error.domain.ErrorInfo;
import com.kenshine.error.exception.CustomException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 16:30
 * @description：全局错误处理
 * @modified By：
 * @version: $
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, CustomException e) throws Exception {
        ErrorInfo<String> info = new ErrorInfo<>();
        info.setMessage(e.getMessage());
        info.setCode(ErrorInfo.ERROR);
        info.setData("JSON格式异常处理信息");
        info.setUrl(req.getRequestURL().toString());
        return info;
    }

}
