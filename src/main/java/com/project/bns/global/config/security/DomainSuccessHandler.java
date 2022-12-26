package com.project.bns.global.config.security;

import com.project.bns.domain.login.application.LoginService;
import com.project.bns.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class DomainSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("로그인 성공 야호!");
        HttpSession session = request.getSession();
        session.setAttribute("login", true);
        session.setAttribute("adminId", authentication.getName());
        session.setMaxInactiveInterval(3600 * 24);

        response.setStatus(200);
        response.sendRedirect(request.getContextPath() + Constant.INDEX_PATH);
    }
}
