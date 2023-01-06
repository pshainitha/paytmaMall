package com.paytmmall.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytmmall.dao.UserInfoDao;
import com.paytmmall.entities.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;

	/* save the user details */
	@Override
	public String saveUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		userInfoDao.save(userInfo);
		return "user Info saved successfully";
	}

	/* delete the user */
	@Override
	public String deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Optional<UserInfo> userExists = userInfoDao.findById(id);
		if (userExists.isPresent()) {
			userInfoDao.deleteById(id);
		}
		return "user with" + id + "deleted successfully";
	}

	/* Check the existence of user */
	@Override
	public Optional<UserInfo> checkifUserExists(String email, String password) {
		// TODO Auto-generated method stub
		Optional<UserInfo> checktheuser = userInfoDao.findByEmailAndPassword(email, password);
		return checktheuser;
	}

	@Override
	public UserInfo findByEmail(String email) {
		// TODO Auto-generated method stub

		return userInfoDao.findByEmail(email);
	}

}
