package com.example.demo.auth;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class checkAuth
{
    @Around("permission")
    public String jwtTokenCreation(ProceedingJoinPoint pjp){
        //TODO : Create token, JWT Token, pjp.proceed
        return "";
    }
}
