package com.statestr.mall.aspect;

import com.statestr.mall.annotation.AuthorCheckAnnotation;
import com.statestr.mall.exception.NoPermissionException;
import com.statestr.mall.util.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by e604845 on 8/16/2017.
 */
@Component
@Aspect
public class AccessAspect extends AbstractAspect{

    private final static Logger logger = LoggerFactory.getLogger(AccessAspect.class);

    @Before("accessLog()")
    public void logBefore(JoinPoint joinPoint){
        HttpServletRequest request = getServletRequest();

        StringBuffer sb = new StringBuffer();
        sb.append("url: "+request.getRequestURL()).append("\t");
        sb.append("method: "+request.getMethod()).append("\t");
        sb.append("ip: "+request.getRemoteAddr()).append("\t");
        //类方法
        sb.append("class: "+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()).append("\t");;
        //参数
        sb.append("args: "+joinPoint.getArgs()).append("\n");
        logger.info(sb.toString());
    }


}
