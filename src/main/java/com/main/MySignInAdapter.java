package com.main;

import com.employee.model.Employee;
import com.employee.model.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * Created by khanguyen on 26/02/2017.
 */
//Can't think of a proper name for this class
public class MySignInAdapter implements SignInAdapter{
    @Autowired
    EmployeeDAO employeeDAO;
    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest nativeWebRequest) {
        //Employee employee = employeeDAO.findByUsername(userId);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userId, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return null;
    }
}
