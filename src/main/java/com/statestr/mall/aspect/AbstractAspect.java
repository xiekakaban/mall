package com.statestr.mall.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by e604845 on 8/16/2017.
 */
public abstract class AbstractAspect {

    /** record every user visit */
    @Pointcut("execution(public * com.statestr.mall.controller.*.*(..))")
    public void accessLog(){}

    /**User Login check*/
    @Pointcut("execution(public * com.statestr.mall.controller.*.*(..)) && @annotation(com.statestr.mall.annotation.AuthorCheckAnnotation)")
    public void loginCheck(){}

    /**Admin Login check*/
    @Pointcut("execution(public * com.statestr.mall.controller.*.*(..)) && @annotation(com.statestr.mall.annotation.AdminAuthorCheckAnnotation)")
    public void adminLoginCheck(){}




    /**Get Request*/
    protected HttpServletRequest getServletRequest(){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }
}
