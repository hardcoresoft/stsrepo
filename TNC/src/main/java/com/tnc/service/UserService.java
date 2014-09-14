package com.tnc.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

public interface UserService extends UserDetailsManager {
	
	public void createUser(UserDetails user);

	public void updateUser(UserDetails user);

	public void deleteUser(String username);

	public void changePassword(String oldPassword, String newPassword);

	public boolean userExists(String username);
}
