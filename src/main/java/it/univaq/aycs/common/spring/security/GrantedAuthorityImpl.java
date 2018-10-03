package it.univaq.aycs.common.spring.security;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private static final String ROLE_PREFIX = "ROLE_";

	
	public GrantedAuthorityImpl() {
		super();
	
	}

	@Override
	public String getAuthority() {
		return  ROLE_PREFIX;
	}

}
