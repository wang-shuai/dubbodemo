package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.lang.reflect.Method;

/**
 * extends LogAspect
 *
 * @author wangshuai
 * @date 2019/7/22
 */
@Aspect
public class LogAspect {
    @Pointcut("@annotation(com.example.aop.LogAnnotation)")
    public void logPointCut() {
        System.out.println("log point cut");
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) {
        System.out.println("enter around log start");
//        LogHelper.error("enter around log start");

        Object result = null;
        try {
            result = point.proceed(point.getArgs());
            System.out.println("调用远程方法正常结束");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        handle(point,null);
        System.out.println("exit around log end");
//        LogHelper.error("exit around log end");

        return result;
    }

    private void handle(JoinPoint joinPoint, Exception e) {

        String signature = joinPoint.getSignature().toString();
        String methodName = signature.substring(signature.lastIndexOf(".") + 1, signature.indexOf("("));
        String classType = joinPoint.getTarget().getClass().getName();
        System.out.println("handle classType: " + classType);
        Class<?> clazz = null;
        try {
            clazz = Class.forName(classType);
        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
            System.out.println(classType + "反射失败，class not found，" + e1.getMessage());
        }

        Method[] methods = new Method[0];
        if (clazz != null) {
            methods = clazz.getDeclaredMethods();
        }
        System.out.println("methodName: " + methodName);

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogAnnotation.class) && method.getName().equals(methodName)) {

                String clazzName = clazz.getName();
                // 序列化  "args:" + joinPoint.getArgs();
                System.out.println("clazzName: " + clazzName + ", methodName: " + methodName);

                LogAnnotation la = method.getAnnotation(LogAnnotation.class);
                System.out.println(la.actionName() + ":" + la.description());
//                LogHelper.error(la.actionName() + ":" + la.description());

            }
        }
    }
}
