 package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.UserDAOimp;
import com.mk.hospital.dto.User;

public class UserService {
	public void saveUser(User user)
	{
		UserDAOimp daoimpl=new UserDAOimp();
		User user1=daoimpl.saveUser(user);
		if(user1!=null)
		{
			System.out.println("Items Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
	}
	public User getUserById(int uid)
	{
		UserDAOimp daoimpl=new UserDAOimp();
		User user=daoimpl.getUserByid(uid);
		if(user!=null)
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	public void deleteUserById(int uid)
	{
		UserDAOimp daoimpl=new UserDAOimp();
		boolean flag=daoimpl.deleteUserByid(uid);
		if(flag)
		{
			System.out.println("Items Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
	}
	public User updateUserById(int uid,User user)
	{
		UserDAOimp daoimpl=new UserDAOimp();
		User user1=daoimpl.UpdateUserById(uid, user);
		if(user1!=null)
		{
			return user1;
		}
		else
		{
			return null;
		}
	}
	public List<User> getAllUser()
	{
		UserDAOimp daoimpl=new UserDAOimp();
		List<User> user=daoimpl.getAllUser();
		if(user.size()>0) {
			return user;
		}
		else
		{
			return null;
		}
	}
	public List<User> getUserByRole(String role)
	{
		UserDAOimp daoimpl=new UserDAOimp();
		List<User> user=daoimpl.getUserByRole(role);
		return user;
	}

}
