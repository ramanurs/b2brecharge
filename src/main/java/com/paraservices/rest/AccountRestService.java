/**
 * 
 */
package com.paraservices.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paraservices.security.config.User;
import com.paraservices.security.config.UserService;

/**
 * @author Ramana
 *
 */
@RestController
public class AccountRestService {
	
	@Autowired
	private UserService userService;

    @RequestMapping(path = "/account/{name}", method = RequestMethod.GET)
    public User getUser(@PathVariable("name") String name) {
    	return userService.findByUsername(name);
    }
}
