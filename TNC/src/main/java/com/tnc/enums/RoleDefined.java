package com.tnc.enums;

public enum RoleDefined {

	Anonymous("ROLE_ANONYMOUS"),
	Admin("ROLE_ADMIN"),
	Manager("ROLE_MANAGER"),
	User("ROLE_USER"),
	Member("ROLE_MEMBER"),
	Developer("ROLE_DEVELOPER")
	;

	public String roleCode;

	private RoleDefined(String roleCode) {
		this.roleCode = roleCode;
	}
}
