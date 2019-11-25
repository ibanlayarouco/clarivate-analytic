package com.clarivate.test.security;

public class Constants {

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

	public static final String ISSUER_INFO = "com.clarivate.test";
	public static final String SUPER_SECRET_KEY = "keyfortest1234";
	public static final long TOKEN_EXPIRATION_TIME = 600_000; // 10 minutos

}
