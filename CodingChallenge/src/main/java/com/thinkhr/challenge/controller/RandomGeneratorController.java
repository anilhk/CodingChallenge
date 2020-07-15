package com.thinkhr.challenge.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkhr.challenge.service.RandomWordService;

/**
 * 
 * @author anil
 * 
 * REST controller to expose an end-point to get a random word from a list of words
 *
 */
@RestController
public class RandomGeneratorController {

	@Autowired
	private RandomWordService randomWordServiceImpl;

	@GetMapping("/getRandomWord")
		public String getRandomWord() throws IOException, URISyntaxException {
			
			return randomWordServiceImpl.getRandomWord();
			
		}
	
	@GetMapping("/")
	public void getMapping(HttpServletRequest request,HttpServletResponse response) throws IOException  {
		
		String redirectUrl = request.getRequestURL()+"getRandomWord";
		response.sendRedirect(redirectUrl);
	}
}
