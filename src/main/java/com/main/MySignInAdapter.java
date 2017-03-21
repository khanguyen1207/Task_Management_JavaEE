package com.main;

import com.employee.model.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public class MySignInAdapter implements SignInAdapter{
    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(userId, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return null;
    }
}
