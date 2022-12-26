package com.project.bns.domain.login.application;

import com.project.bns.domain.login.dao.LoginMapper;
import com.project.bns.domain.model.Admin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMapper loginMapper;

    public Admin findAdminInformation(String adminId){
        return loginMapper.findAdminInformation(adminId);
    }

    public int adminIdDuplicateCheck(String adminId) {
        return loginMapper.adminIdDuplicateCheck(adminId);
    }
}
