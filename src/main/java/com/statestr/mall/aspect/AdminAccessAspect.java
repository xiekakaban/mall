package com.statestr.mall.aspect;

import com.statestr.mall.annotation.AdminAuthorCheckAnnotation;
import com.statestr.mall.exception.NoAdminPermissionException;
import com.statestr.mall.exception.NoPermissionException;
import com.statestr.mall.util.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by e604845 on 8/16/2017.
 */
@Component
@Aspect
public class AdminAccessAspect extends AbstractAspect{

    private static final Boolean ISDEV = Boolean.TRUE;

    @Before("adminLoginCheck()")
    public void adminLoginCheckBefore (JoinPoint joinPoint) throws NoPermissionException{

        HttpServletRequest request = getServletRequest();
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        AdminAuthorCheckAnnotation adminAuthorCheckAnnotation = methodSignature.getMethod().getAnnotation(AdminAuthorCheckAnnotation.class);
        //需要进行权限检查
        if(adminAuthorCheckAnnotation != null && adminAuthorCheckAnnotation.value() == Boolean.TRUE){
            if(request.getSession().getAttribute(Constants.ADMINSESS_USER) == null){
                throw new NoAdminPermissionException();
            }
        }
    }
}
