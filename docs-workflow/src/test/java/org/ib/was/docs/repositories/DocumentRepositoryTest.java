package org.ib.was.docs.repositories;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMockMvc
//@ContextConfiguration(classes = {BirthdayInfoController.class, BasicBirthdayService.class})
@WebMvcTest
public class DocumentRepositoryTest {

	
	@Test
	void lambdaExpressions() {
		
	}
	
	@BeforeAll
	static void setup() {
	    log.info("@BeforeAll - executes once before all test methods in this class");
	}

	@BeforeEach
	void init() {
	    log.info("@BeforeEach - executes before each test method in this class");
	}
	
	@AfterEach
	void tearDown() {
	    log.info("@AfterEach - executed after each test method.");
	}

	@AfterAll
	static void done() {
	    log.info("@AfterAll - executed after all test methods.");
	}
}
