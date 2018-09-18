package com.customs.aspec;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect()
@Component
public class LoginCheckAspec {
	@Autowired
	private HttpServletRequest request;
	ThreadLocal<Long> beginTime = new ThreadLocal<>();

	@Pointcut("@annotation(com.customs.annotation.LoginCheck)")
	public void annotationPointCut() {

	}

	@Before(value = "annotationPointCut()")
	public void before(JoinPoint joinPoint) {
		String methodName = getMethodName(joinPoint);
		beginTime.set(System.currentTimeMillis());
		System.out.println(methodName + "开始时间：" + System.currentTimeMillis());
	}

	@After(value = "annotationPointCut()")
	public void after(JoinPoint joinPoint) {
		String methodName = getMethodName(joinPoint);
		System.out.println(methodName + "结束時間：" + System.currentTimeMillis());
		System.out.println(methodName + "耗時：" + (System.currentTimeMillis() - beginTime.get()));
	}

	private String getMethodName(JoinPoint joinPoint) {
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		Method method = sign.getMethod();
		String methodName = method.getName();
		return methodName;
	}
}
