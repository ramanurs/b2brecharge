package com.paraservices.security.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author Ramana
 *
 */
@Component
public interface UserService extends UserDetailsService {
	public User findByUsername(String username);
	public UserDetails findUserDetailsByUsername(String username);
	public UserDetails getUserDetailsFromUser(User user);
}
