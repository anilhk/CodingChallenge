package com.thinkhr.challenge.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.thinkhr.challenge.service.RandomWordService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RandomGeneratorController.class)
@WithMockUser
public class RandomGeneratorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RandomWordService randomWordServiceImpl;

	@Test
	public void getAPITogetRandomGreeting() throws Exception {
		when(randomWordServiceImpl.getRandomWord()).thenReturn("this is MOCK response");
		
		this.mockMvc.perform(get("/getRandomWord")).andDo(print())
				.andExpect(content().string(containsString("MOCK")));
	}

}
