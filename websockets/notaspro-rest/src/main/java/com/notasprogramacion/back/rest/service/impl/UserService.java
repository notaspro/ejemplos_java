package com.notasprogramacion.back.rest.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.notasprogramacion.back.rest.model.dto.User;
import com.notasprogramacion.back.rest.model.dto.UserRole;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		user.setEnabled(true);
		System.out.println(passwordEncoder.encode("12345"));
		user.setPassword("$2a$10$yBf.kkrb28YCudEN2/xkJ.YEOT1D./Eelrx.RS6xBaSvHDCBt.sGK");
		user.setUsername("notaspro");
		Set<UserRole> userRoles = new HashSet<UserRole>();
		UserRole userRole = new UserRole();
		userRole.setUserRoleId(1);
		userRole.setRole("ROLE_ADMIN");
		UserRole userRole2 = new UserRole();
		userRole2.setUserRoleId(2);
		userRole2.setRole("ROLE_USER");
		userRoles.add(userRole);
		userRoles.add(userRole2);
		user.setUserRole(userRoles);
		//User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}

	private org.springframework.security.core.userdetails.User buildUser(User user,
			List<GrantedAuthority> authorities) {

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		return new ArrayList<GrantedAuthority>(auths);
	}
}
