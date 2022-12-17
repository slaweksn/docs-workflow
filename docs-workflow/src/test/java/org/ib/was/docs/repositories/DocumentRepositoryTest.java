package org.ib.was.docs.repositories;

import java.util.List;

import org.ib.was.docs.dto.DocumentView;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DocumentRepositoryTest {

	@Autowired
	private DocumentRepository repository;

	@Test
	void whenUsingClosedProjections_thenViewWithRequiredPropertiesIsReturned() {

		List<DocumentView> findBy = repository.findBy(DocumentView.class);

		findBy.forEach(p -> System.out.println(p));

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
