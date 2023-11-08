package com.contact.contactApp.model;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.List;
@Entity
public class UserInfo implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long infoId;
    private String userName;
    private String passWord;
    private String role;

    @OneToOne(mappedBy = "userInfo")
    private UserDomain userDomain;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }
    @Override
    public String getPassword() {
        return passWord;
    }
    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public void setId(Long id) {
        this.infoId = id;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }
    public Long getId() {
        return infoId;
    }
    public String getRole() {
        return role;
    }
    public UserDomain getUserDomain() {
        return userDomain;
    }
}

    


