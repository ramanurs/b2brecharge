package com.paraservices.security.config;

import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Ramana
 *
 */
@Component
public class UserServiceImpl implements UserService {
	
	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UsersRepository userRepository;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		logger.info("loadUserByUsername:: Got user for "+user);
		UserDetails userDetails = getUserDetailsFromUser(user);
		return userDetails;
	}

	/* (non-Javadoc)
	 * @see com.paraservices.services.UserService#findByUsername(java.lang.String)
	 */
	public User findByUsername(String username) {
		logger.info("findByUsername:: Getting user for "+username);
		User user = userRepository.loadUserByUsername(username);
		logger.info("findByUsername:: Got user for "+user);
		return user;
	}

	public UserDetails getUserDetailsFromUser(User user) {
		UserDetails userDetails = new AuthUser(user.getId(), user.getUsername(), user.getEmailId(), user.getPassword(), true, new ArrayList(), new Date());
		logger.info("getUserDetailsFromUser:: Returning userDetails : "+userDetails);
		return userDetails;
	}

	public UserDetails findUserDetailsByUsername(String username) {
		User user = findByUsername(username);
		logger.info("loadUserByUsername:: Got user for "+user);
		UserDetails userDetails = getUserDetailsFromUser(user);
		return userDetails;
	}

}
