package com.dgut.spring.aop.aspectJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyAspect {
	
	@Pointcut("execution(* com.dgut.spring.aop.aspectJ.Calculator.*(..))")
	public void myPointCut() {}
	
	@Before("myPointCut()")
	public void beforeAnnounce(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("Before Announcement===> Method " + methodName + " start with " + Arrays.asList(args));
	}
	
	@After("myPointCut()")
	public void afterAnnounce(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("After Announcement===> Method " + methodName + " execute.");
	}
	
	@AfterReturning(value = "myPointCut()", returning="result")
	public void afterReturnAnnounce(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName();
		System.out.println("AfterReturning Announcement===> Method " + methodName + " return with: " + result);
	}
	
	@AfterThrowing(value="myPointCut()", throwing="ex")
	public void afterThrowingAnnounce(JoinPoint jp, ArithmeticException ex) {
		String methodName = jp.getSignature().getName();
		System.out.println("AfterThrowing Announcement===> Method " + methodName + " run with execption: " + ex.getMessage());
		
	}
	
	@Around("myPointCut()")
	public Object aroundAnnounce(ProceedingJoinPoint pjp) {
		Object result = null;
		//before announce
		//System.out.println("Around Announcement before");
		try {
			result = pjp.proceed();
			//returning announcement
			//System.out.println("Around Announcement after");
			return result;
		} catch (Throwable e) {
			//throwing announcement
			e.printStackTrace();
		} finally {
			//after announcement
		}
		return result;
		
	}
}
