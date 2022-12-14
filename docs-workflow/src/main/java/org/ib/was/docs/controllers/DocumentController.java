package org.ib.was.docs.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> test(@RequestParam("id") String id) {

		Map<String, Object> map = new HashMap<>();
		map.put("klucz", "wartosc");
		map.put("data", LocalDateTime.now());
		
		List<Document> documents = documentService.getaAllDocuments();
		System.out.println("docs: " + documents);
		return ResponseEntity.ok(map);
	}
}
