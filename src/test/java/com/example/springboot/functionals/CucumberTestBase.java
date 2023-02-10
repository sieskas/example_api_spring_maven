package com.example.springboot.functionals;

import com.example.springboot.DemoApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(
		classes = DemoApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("integration")
public abstract class CucumberTestBase {}
