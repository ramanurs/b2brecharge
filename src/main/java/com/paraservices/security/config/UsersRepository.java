package com.paraservices.security.config;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface UsersRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.username like %?1")
	User loadUserByUsername(String username);
}
