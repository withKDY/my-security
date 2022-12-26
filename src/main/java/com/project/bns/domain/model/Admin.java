package com.project.bns.domain.model;


import lombok.Getter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@ToString
@Alias("Admin")
public class Admin implements UserDetails {
    private long adminNo;
    private String adminId;
    private String adminPw;
    private String adminPhone;
    private String adminEmail;
    private String adminName;
    private String adminActive;
    private String adminCreatedDate;
    private String adminModifiedDate;
    private String adminRole;
    private String adminProfilePath;
    private String adminProfileOriginName;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(adminRole));
        return authorities;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return adminPw;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return adminId;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
}
