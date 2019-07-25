package com.example.aop;

import java.lang.annotation.*;

/**
 * Created by wangshuai on 2019/7/22.
 */

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    String actionName() default "";
    String description() default "";
}
