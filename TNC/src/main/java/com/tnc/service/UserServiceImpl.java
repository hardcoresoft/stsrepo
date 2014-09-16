package com.tnc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.tnc.dao.UserDao;
import com.tnc.domain.Role;
import com.tnc.domain.User;

/**
 * A custom {@link UserDetailsService} where user information is retrieved from
 * a JPA repository
 */
@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public User getUser(String username) throws UsernameNotFoundException {
		return (User) loadUserByUsername(username);
	}

	@Override
	public User createUser(User user) {
		Assert.isTrue(!userExists(user.getUsername()));
		return userDao.saveOrUpdate(user);
	}

	@Override
	public void createUser(UserDetails user) {
		Assert.isTrue(!userExists(user.getUsername()));
		userDao.save((User) user);
	}

	@Override
	public User updateUser(User user) {
		Assert.isTrue(userExists(user.getUsername()));
		return userDao.saveOrUpdate(user);
	}

	@Override
	public void updateUser(UserDetails user) {
		Assert.isTrue(userExists(user.getUsername()));
		userDao.update((User) user);
	}

	@Override
	public void deleteUser(String username) {
		Assert.isTrue(userExists(username));
		userDao.delete(username);
	}

	@Override
	public boolean userExists(String username) {
		return userDao.exists(username.toLowerCase());
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();

		if (currentUser == null) {
			// This would indicate bad coding somewhere
			throw new AccessDeniedException("Can't change password as no Authentication object found in context "
					+ "for current user.");
		}

		String username = currentUser.getName();

		// logger.debug("Changing password for user '" + username + "'");

		// If an authentication manager has been set, re-authenticate the user
		// with the supplied password.
		if (authenticationManager != null) {
			// logger.debug("Reauthenticating user '" + username +
			// "' for password change request.");

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
		} else {
			// logger.debug("No authentication manager set. Password won't be re-checked.");
		}

		User user = userDao.get(username.toLowerCase());

		if (user == null) {
			throw new IllegalStateException("Current user doesn't exist in system.");
		}

		user.setPassword(newPassword);
	}

	/**
	 * Returns a populated {@link UserDetails} object. The username is first
	 * retrieved from the database and then mapped to a {@link UserDetails}
	 * object.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.get(username.toLowerCase());

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		try {
			return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(),
					user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical
	 * role
	 * 
	 * @param role
	 *            the numerical role
	 * @return a collection of {@link GrantedAuthority

	 */
	public Collection<? extends GrantedAuthority> getAuthorities(com.tnc.domain.User domainUser) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(domainUser));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * 
	 * @param role
	 *            the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(com.tnc.domain.User domainUser) {
		List<String> authorities = new ArrayList<String>();

		List<Role> roles = domainUser.getRoles();
		for (Role role : roles) {
			authorities.add(role.getRoleCode());
		}
		return authorities;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * 
	 * @param roles
	 *            {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	// private UserRepository repository;

	// @Autowired
	// public RepositoryUserService(PasswordEncoder passwordEncoder,
	// UserRepository repository) {
	// this.passwordEncoder = passwordEncoder;
	// this.repository = repository;
	// }
	//
	@Transactional
	@Override
	public User registerNewUserAccount(User user) throws Exception {

		// if (emailExist(user.getEmail())) {
		// throw new DuplicateEmailException("The email address: " +
		// user.getEmail() + " is already in use.");
		// }

		String encodedPassword = encodePassword(user.getPassword());
		user.setPassword(encodedPassword);
		return userDao.saveOrUpdate(user);
	}

	// private boolean emailExist(String email) {
	// User user = userDao.findByEmail(email);
	// if (user != null) {
	// return true;
	// }
	// return false;
	// }

	private String encodePassword(String plainText) throws Exception {
		String encodedPassword = null;

		if (plainText != null) {
			encodedPassword = passwordEncoder.encode(plainText);
		} else {
			throw new Exception("Password cannot be null!");
		}
		return encodedPassword;
	}
}
