package com.dgut.spring.aop.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	
	public void beforeAnnounce(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("Before Announcement===> Method " + methodName + " start with " + Arrays.asList(args));
	}
	
	public void afterAnnounce(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("After Announcement===> Method " + methodName + " execute.");
	}
	
	public void afterReturnAnnounce(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName();
		System.out.println("AfterReturning Announcement===> Method " + methodName + " return with: " + result);
	}
	
	public void afterThrowingAnnounce(JoinPoint jp, Exception ex) {
		String methodName = jp.getSignature().getName();
		System.out.println("AfterThrowing Announcement===> Method " + methodName + " run with execption: " + ex.getMessage());
		
	}
	
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
