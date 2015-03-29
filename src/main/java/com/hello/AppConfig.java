package com.hello;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AppConfig {

  @Aspect
  @Component
  public static class DoBeforeAspect {

    @Before("execution(* com.hello.GreetingService.get(..))")
    public void doBefore(JoinPoint joinPoint) {
      System.out.println("***AspectJ*** before " + joinPoint.getSignature());
    }
  }
}