package com.gonzasilve.puntoventas.pvcore.service.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class PVSecurityService implements UserDetailsService {

	//Borrar para implementar esta clase
	@Override
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
/*
	@Override
	public UserDetails loadUserByUsername(String username)	throws UsernameNotFoundException {
		//Aqui se carga un usuario por nombre de usuario
		
		// Declare a null Spring User
		UserDetails user = null;
		
		try {

			// Search database for a user that matches the specified username
			// You can provide a custom DAO to access your persistence layer
			// Or use JDBC to access your database
			// DbUser is our custom domain user. This is not the same as
			// Spring's User
			//Usuario u = usuarioDao.selectUsuario(nombre).get(0);
			Usuario u = new Usuario();
			u.setId(1);
			u.setNombre("Gonzalo");
			u.setApellidoPaterno("Perez");
			u.setApellidoMaterno("Silverio");
			u.setCasado(true);
			u.setEdad(30);
			u.setPsw("827ccb0eea8a706c4c34a16891f84e7b");	//12345
			System.out.println("Nombre: "+u.getNombre());
			System.out.println("Password: "+u.getPsw());


			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct
			// role type
			
			//Aqui se da de alta un usuario
			user = new User(u.getNombre(), u.getPsw().toLowerCase(), true,	true, true, true, getAuthorities(1));
			
		} catch( UsernameNotFoundException infe ) {
			throw new UsernameNotFoundException("error al obtener el usuario");
		}
		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is
		// authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;

	}


	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		if (access.compareTo(1) == 0) {
			// User has admin access

			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		} else if (access.compareTo(0) == 0) {

			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		}

		// Return list of granted authorities
		return authList;
	}
*/
	
}
