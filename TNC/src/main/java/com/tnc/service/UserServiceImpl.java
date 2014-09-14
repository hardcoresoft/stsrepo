package com.tnc.service;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.security.core.userdetails.memory.UserAttributeEditor;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.util.Assert;

import com.tnc.dao.UserDao;
import com.tnc.domain.User;

public class UserServiceImpl implements UserService {

	protected final Log logger = LogFactory.getLog(getClass());

	private UserDao userDao;

	private AuthenticationManager authenticationManager;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}


//	public User convert(UserDetails userDetails) {
//		UserDetails user = new User(name, attr.getPassword(), attr.isEnabled(), true, true, true, attr.getAuthorities());
//		createUser(user);
//	}

	public void createUser(UserDetails user) {
		Assert.isTrue(!userExists(user.getUsername()));

		
//		userDao.save((User)user);

	}

	public void deleteUser(String username) {
		userDao.delete(username);
	}

	public void updateUser(UserDetails user) {
		Assert.isTrue(userExists(user.getUsername()));

	}

	public boolean userExists(String username) {
		return userDao.exists(username.toLowerCase());
	}

	public void changePassword(String oldPassword, String newPassword) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

		if (currentUser == null) {
			// This would indicate bad coding somewhere
			throw new AccessDeniedException("Can't change password as no Authentication object found in context "
					+ "for current user.");
		}

		String username = currentUser.getName();

		logger.debug("Changing password for user '" + username + "'");

		// If an authentication manager has been set, re-authenticate the user
		// with the supplied password.
		if (authenticationManager != null) {
			logger.debug("Reauthenticating user '" + username + "' for password change request.");

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
		} else {
			logger.debug("No authentication manager set. Password won't be re-checked.");
		}

		User user = userDao.get(username);

		if (user == null) {
			throw new IllegalStateException("Current user doesn't exist in system.");
		}

		user.setPassword(newPassword);
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userDao.get(username.toLowerCase());

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
				user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
	}

}
