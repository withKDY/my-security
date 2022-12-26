package com.project.bns.domain.login.dao;

import com.project.bns.domain.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    Admin findAdminInformation(@Param("adminId") String adminId);

    int adminIdDuplicateCheck(@Param("adminId") String adminId);
}
