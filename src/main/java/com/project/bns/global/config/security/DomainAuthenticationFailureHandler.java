package com.project.bns.global.config.security;

import com.project.bns.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class DomainAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
        log.info("로그인 실패 ㅠㅠ");

        String errMsg = "", path = Constant.LOGIN_PATH;

        if (exception instanceof UsernameNotFoundException) {
            errMsg = "userID";
        }
        else if (exception instanceof BadCredentialsException) {
            errMsg = "password";
        }
        else if (exception instanceof DisabledException){
            errMsg = "disabled";
        }

        path = path + "?errMsg=" + errMsg;

        response.setStatus(401);
        response.sendRedirect(path);
    }
}
