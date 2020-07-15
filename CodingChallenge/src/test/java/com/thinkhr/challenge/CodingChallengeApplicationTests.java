package com.thinkhr.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.thinkhr.challenge.controller.RandomGeneratorController;

@SpringBootTest
class CodingChallengeApplicationTests {

	@Autowired
	private RandomGeneratorController randomGeneratorController;
	
	@Test
	void contextLoads() {
		assertThat(randomGeneratorController).isNotNull();
	}

}
