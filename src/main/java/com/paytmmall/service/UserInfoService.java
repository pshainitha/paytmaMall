package com.paytmmall.service;

import java.util.Optional;

import com.paytmmall.entities.UserInfo;

public interface UserInfoService {

	String saveUserInfo(UserInfo userInfo);

	String deleteUser(Integer id);

	Optional<UserInfo> checkifUserExists(String email, String password);

	

}