package org.ib.was.docs.controllers;

import java.util.List;

import org.ib.was.docs.models.Document;
import org.ib.was.docs.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	public DocumentController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Document>> all() {
		
		List<Document> documents = documentService.getAllDocuments();
		
		return ResponseEntity.ok(documents);
	}
	
	@GetMapping(path = "/document", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Document> document(@RequestParam("id") Long id) {
		
		Document document = documentService.getDocument(id);
		
		return ResponseEntity.ok(document);
	}
}
