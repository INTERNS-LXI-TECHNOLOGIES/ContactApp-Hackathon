package com.hackathon.contactweb.model;


import lombok.Data;

public class UserDTO {
    private Long id;
    private String userName;
    private String passWord;
    private String role;
    private Long domainUserId;
    private String domainUserName;
    private Long domainUserPhoneNumber;
    private String domainUserEmailAddress;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Long getDomainUserId() {
        return domainUserId;
    }
    public void setDomainUserId(Long domainUserId) {
        this.domainUserId = domainUserId;
    }
    public String getDomainUserName() {
        return domainUserName;
    }
    public void setDomainUserName(String domainUserName) {
        this.domainUserName = domainUserName;
    }
    public Long getDomainUserPhoneNumber() {
        return domainUserPhoneNumber;
    }
    public void setDomainUserPhoneNumber(Long domainUserPhoneNumber) {
        this.domainUserPhoneNumber = domainUserPhoneNumber;
    }
    public String getDomainUserEmailAddress() {
        return domainUserEmailAddress;
    }
    public void setDomainUserEmailAddress(String domainUserEmailAddress) {
        this.domainUserEmailAddress = domainUserEmailAddress;
    }
}

