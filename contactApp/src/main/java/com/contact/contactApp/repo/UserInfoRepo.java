package com.contact.contactApp.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.contact.contactApp.model.UserInfo;
public interface UserInfoRepo extends CrudRepository<UserInfo,Long>{
    Optional<UserInfo> findByUserName(String userName);
}
