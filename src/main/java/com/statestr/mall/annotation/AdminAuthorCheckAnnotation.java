package com.statestr.mall.annotation;
import java.lang.annotation.*;

/**
 * Created by e604845 on 8/16/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AdminAuthorCheckAnnotation {
    // 是否进行权限检查
    boolean value() default false;
}
