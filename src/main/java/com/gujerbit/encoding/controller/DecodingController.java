package com.gujerbit.encoding.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin("*")
@Controller
public class DecodingController {

	@GetMapping("/encoding")
	public @ResponseBody Object[] getEncoding(HttpServletRequest req) {
		
		String str = req.getQueryString();
		System.out.println(str);
		
		String value = req.getParameter("param");
		Object[] result = new Object[3];
		result[0] = value;
		
		try {
			result[1] = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		result[2] = base64Encoding(value);
		
		return result;
	}
	
	@PostMapping("/encoding")
	public @ResponseBody Object[] postEncoding(@RequestBody String value) {
		value = value.replaceAll("[{}\"]", "");
		value = value.split(":")[1];
		Object[] result = new Object[3];
		result[0] = value;
		
		try {
			result[1] = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		result[2] = base64Encoding(value);
		
		return result;
	}
	
	private byte[] base64Encoding(String value) {
		Encoder encoder = Base64.getEncoder();
		
		return encoder.encode(value.getBytes());
	}
	
}
