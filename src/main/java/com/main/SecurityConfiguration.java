/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.main;

import com.employee.model.EmployeeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.ResponseJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "select username, password, enabled from Employee where username=?")
                .authoritiesByUsernameQuery("select username, role from Employee where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/built/**", "/main.css").permitAll()
                .antMatchers("/employee/update","/employee/create", "/employee/delete").access("hasRole('HR')")
                .antMatchers("/task/create").access("hasRole('ADMIN')")
                .antMatchers("/").permitAll()
                .antMatchers("/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    System.out.println(authentication.getName());
                    httpServletResponse.setContentType("application/json");
                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = mapper.writeValueAsString(employeeDAO.findByUsername(authentication.getName()));
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.getWriter().write(jsonString);

                })
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json");
                    ObjectMapper mapper = new ObjectMapper();
                    String jsonString = mapper.writeValueAsString(new ResponseJSON("Login failed - Wrong password"));
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
                    httpServletResponse.getWriter().write(jsonString);
                })
                //.defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .logout()
//                .addLogoutHandler((httpServletRequest, httpServletResponse, authentication) -> {
//
//                })
//                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID");
        http.exceptionHandling().authenticationEntryPoint((httpServletRequest, httpServletResponse, e) -> {
            if (e != null) {
                httpServletResponse.setContentType("application/json");
                ObjectMapper mapper = new ObjectMapper();
                String jsonString = mapper.writeValueAsString(new ResponseJSON("Login failed - entrypoint"));
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpServletResponse.getWriter().write(jsonString);
            }
        });
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/resources/**"); // #3
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
// end::code[]