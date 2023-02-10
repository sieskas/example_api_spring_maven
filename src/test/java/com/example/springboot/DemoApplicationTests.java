package com.example.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = DemoApplication.class)
@ActiveProfiles("integration")
class DemoApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("com.example.springboot.DemoApplicationTests", this.getClass().getName());
	}
}
