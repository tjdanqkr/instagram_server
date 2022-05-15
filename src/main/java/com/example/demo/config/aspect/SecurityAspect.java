package com.example.demo.config.aspect;

import com.example.demo.config.security.SecurityService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.InvalidParameterException;
import java.security.Key;

@Aspect
@Component
public class SecurityAspect {
    @Autowired
    SecurityService securityService;
    @Value("{jwt.SECRET_KEY}")
    String SECRET_KEY;

    @Before("@annotation(tokenRequired)")
    public void authenticateWithToken(TokenRequired tokenRequired){
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String token = request.getHeader("Authorization");
        if(StringUtils.isEmpty(token)){
            throw new IllegalArgumentException("token is null");
        }
        String removeBearerToken = token.substring("Bearer ".length());
        if (securityService.getClaims(removeBearerToken) == null) {
            throw new IllegalArgumentException("token error");
        }

    }

}
