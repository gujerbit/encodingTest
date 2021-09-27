package com.gujerbit.encoding.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.Base64.Decoder;

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

	@GetMapping("/none_encoding")
	public @ResponseBody String getNoneEncoding(HttpServletRequest req) {
		System.out.println("none get: " + req.getParameter("param"));
		System.out.println("none get querystring: " + req.getQueryString());
		return req.getParameter("param");
	}
	
	@PostMapping("/none_encoding")
	public @ResponseBody String postNoneEncoding(@RequestBody String value) {
		System.out.println("none post: " + value);
		return value;
	}
	
	@GetMapping("/encoding")
	public @ResponseBody String getEncoding(HttpServletRequest req) throws UnsupportedEncodingException {
		System.out.println("encoding get: " + req.getParameter("param"));
		System.out.println("encoding get querystring: " + req.getQueryString());
		return URLDecoder.decode(req.getParameter("param"), "UTF-8");
	}
	
	@PostMapping("/encoding")
	public @ResponseBody String postEncoding(@RequestBody String value) throws UnsupportedEncodingException {
		System.out.println("encoding post: " + value);
		return URLDecoder.decode(value, "UTF-8");
	}
	
	@GetMapping("/base64")
	public @ResponseBody Object getBase64(HttpServletRequest req) {
		System.out.println("base64 get: " + req.getParameter("param"));
		System.out.println("base64 get querystring: " + req.getQueryString());
		return base64Decoding(req.getParameter("param").getBytes());
	}
	
	@PostMapping("/base64")
	public @ResponseBody Object postBase64(@RequestBody String value) {
		System.out.println("base64 post: " + value);
		return base64Decoding(value.getBytes());
	}
	
	private byte[] base64Decoding(byte[] value) {
		Decoder decorder = Base64.getDecoder();
		return decorder.decode(value);
	}
	
}
