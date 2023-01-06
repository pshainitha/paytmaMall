package com.paytmmall.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.paytmmall.entities.PaytmMallCart;

@Repository
public interface CartDao extends JpaRepository<PaytmMallCart, Integer> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM PaytmMallCart  WHERE useremail=?1 AND pid=?2")
	public void deleteproductincart(String email, Integer pid);

}
