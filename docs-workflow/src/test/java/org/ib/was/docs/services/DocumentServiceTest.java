package org.ib.was.docs.services;

import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.ib.was.docs.dto.DocumentView;
import org.ib.was.docs.models.Document;
import org.ib.was.docs.repositories.DocumentRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@AutoConfigureMockMvc
//@ContextConfiguration(classes = {DocumentRepository.class, DocumentService.class})
//@WebMvcTest
//@ExtendWith(MockitoExtension.class)
//@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SpringBootTest
class DocumentServiceTest {
	
	//@MockBean
	//private DocumentRepository repository;
	
	@Autowired
	private DocumentService documentService;
	
	@Test
	void test01() {
		
		List<DocumentView> documentViews = documentService.findAllDocumentsView();
		documentViews.forEach(p->System.out.println("service: " + p));
	}
	/*-
	//@Mock
	@MockBean
    private DocumentRepository documentRepository;

    //@InjectMocks
	@Autowired
    private DocumentService documentService;
    
    
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
	
	@Test
	void should_find_and_return_all_documents() throws Exception {

		Document document1 = new Document();
		document1.setId(1l);
		document1.setName("document_01");

		Document document2 = new Document();
		document2.setId(1l);
		document2.setName("document_01");
		List<Document> params = Arrays.asList(document1, document2);

		doReturn(params).when(documentRepository).findAll();

		List<Document> documents = documentService.findAllDocuments();

		Assertions.assertEquals(params.size(), documents.size(), "findAll should return 2 widgets");
	}
	
	@Test
	void should_find_and_return_one_document() throws Exception {
		
		
		Document document = new Document();
		document.setId(1l);
		document.setName("document_01");
		
		doReturn(Optional.of(document)).when(documentRepository).findById(1l);
		
		Document document2 = documentService.findDocument(1l);
		
		Assertions.assertNotNull(document2, "Widget was not found");
		Assertions.assertSame(document2, document, "The widget returned was not the same as the mock");
	}
	*/
}
