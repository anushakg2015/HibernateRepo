package com.mk.hospital.dao;

import java.util.List;

import com.mk.hospital.dto.User;

public interface UserDAO {
	public User saveUser(User user);
	public User getUserByid(int uid);
	public boolean deleteUserByid(int uid);
	public User UpdateUserById(int uid,User User);
	public List<User> getAllUser();
	public List<User> getUserByRole(String role);

}
