package com.paytmmall.service;

import java.util.Optional;

import com.paytmmall.entities.UserInfo;

public interface UserInfoService {

	/* save the user details */
	String saveUserInfo(UserInfo userInfo);

	/* delete the user */
	String deleteUser(Integer id);

	/* Check the existence of user */
	Optional<UserInfo> checkifUserExists(String email, String password);

	UserInfo findByEmail(String email);

}