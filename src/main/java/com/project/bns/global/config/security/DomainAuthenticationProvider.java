package com.project.bns.global.config.security;

import com.project.bns.domain.admin.util.AdminEnum;
import com.project.bns.domain.login.application.LoginService;
import com.project.bns.domain.model.Admin;
import com.project.bns.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class DomainAuthenticationProvider implements AuthenticationProvider {

    @Lazy
    private final PasswordEncoder passwordEncoder;

    private final LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String adminId = authentication.getName();

        int count = loginService.adminIdDuplicateCheck(adminId);

        Admin admin = loginService.findAdminInformation(authentication.getName());

        if (count > Constant.MIN) {
            throw new UsernameNotFoundException("아이디를 확인 해주십시오.");
        }else if (Objects.equals(admin.getAdminActive(), AdminEnum.NOT_ACTIVE.values())){
            throw new DisabledException("비활성화 계정입니다.");
        }

        if (!passwordEncoder.matches(authentication.getCredentials().toString(), admin.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다");
        }
        else {
            return new UsernamePasswordAuthenticationToken(admin, null, admin.getAuthorities());
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
