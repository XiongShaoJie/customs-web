package com.customs.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//说明该注解将被包含在javadoc中
@Documented
//@Retention: 定义注解的保留策略,
//注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Retention(RetentionPolicy.RUNTIME)
//@Target：定义注解的作用目标
//方法和方法参数
@Target({ ElementType.METHOD, ElementType.PARAMETER })
//说明子类可以继承父类中的该注解
@Inherited 
public @interface LoginCheck {

	boolean check() default false;
}
