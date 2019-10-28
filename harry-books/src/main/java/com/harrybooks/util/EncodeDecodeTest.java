package com.harrybooks.util;

import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodeDecodeTest {

	private static String decodeUrl(String encoded) {
		 byte[] actualByte = Base64.getDecoder().decode(encoded); 
		 return new String(actualByte); 
	}

	private static String encodePassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode("123");
	}	
	
	public static void main(String[] args) {
		System.out.println("URL::" + decodeUrl("aHR0cHM6Ly9kb2NzLmdvb2dsZS5jb20vYS9hbGRlYW1vLmNvbS9kb2N1bWVudC9kLzFWV1oxN3QwdWNIUzIteXNyeTFVREhHYjBiVFExRS1HV0ZNRGZHQUZFYUV3L2VkaXQ/dXNwPXNoYXJpbmc=")); 
		System.out.println("Password::"+encodePassword());
	}

}
