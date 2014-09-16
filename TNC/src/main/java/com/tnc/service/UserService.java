package com.tnc.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import com.tnc.domain.User;

public interface UserService extends UserDetailsManager, UserDetailsService {

	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(String username);

	public void changePassword(String oldPassword, String newPassword);

	public boolean userExists(String username);

	public User getUser(String username) throws UsernameNotFoundException;
	
	public User registerNewUserAccount(User user) throws Exception;
}
