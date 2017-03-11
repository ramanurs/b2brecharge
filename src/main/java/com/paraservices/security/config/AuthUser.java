package com.paraservices.security.config;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AuthUser implements UserDetails {

	private Long id;
	private String username;
	private String password;
	private String email;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean enabled;
	private Date lastPasswordResetDate;

	public AuthUser(Long id, String username, String email, String password, boolean enabled,  
			Collection<? extends GrantedAuthority> authorities, Date lastPasswordResetDate
	    ) {
	        this.id = id;
	        this.username = username;
	        this.email = email;
	        this.password = password;
	        this.authorities = authorities;
	        this.enabled = enabled;
	        this.lastPasswordResetDate = lastPasswordResetDate;
	    }
	@JsonIgnore
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
 
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}
