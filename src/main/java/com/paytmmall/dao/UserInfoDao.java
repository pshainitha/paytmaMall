package com.paytmmall.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paytmmall.entities.UserInfo;
@Repository
public interface UserInfoDao extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByEmailAndPassword(String email, String password);



}
