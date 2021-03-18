package com.userinfo.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGen {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawPass="nepal123";
		String encodedPass=encoder.encode(rawPass);
		System.out.println(encodedPass);
	}
}
