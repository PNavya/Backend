package com.niit.ShoppingCart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.ShoppingCart.model.UserDetails;
import com.niit.ShoppingCart.model.UserDetails;

@Repository
public interface UserDetailsDAO {

	public boolean save(UserDetails userdetails);
	public boolean update(UserDetails userdetails);
	public boolean delete(UserDetails userdetails);
	public UserDetails get(String id);
	public List<UserDetails> list();

	
}
