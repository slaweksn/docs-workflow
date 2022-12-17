package org.ib.was.docs.controllers;

import java.util.List;

import org.ib.was.docs.dto.DocumentView;
import org.ib.was.docs.models.Document;
import org.ib.was.docs.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/documents", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentController {

	@Autowired
	private DocumentService documentService;
	
	//Autowired
	//private ModelMapper mapper;
	
	@GetMapping(path = "/view")
	public ResponseEntity<List<DocumentView>> documentView() {
		
		List<DocumentView> document = documentService.findAllDocumentsView();
		//DocumentDTO dto = mapper.map(document, DocumentDTO.class);
		
		return ResponseEntity.ok(document);
	}
	
	@GetMapping
	public ResponseEntity<Document> document(@RequestParam("id") Long id) {
		
		Document document = documentService.findDocument(id);
		
		return ResponseEntity.ok(document);
	}
	
	@PostMapping
	public ResponseEntity<Document> insert(@RequestBody Document document) {
		
		//document.getAttachments().forEach(p->p.setDocument(document));
		//SqlExceptionHelper x;
		Document documentResponse = documentService.saveDocument(document);
		
		return ResponseEntity.ok(documentResponse);
	}
	
	@PutMapping
	public ResponseEntity<Document> update(@RequestBody Document document) {
		
		Document documentResponse = documentService.saveDocument(document);
		
		return ResponseEntity.ok(documentResponse);
	}
	
	
	/*-
	@GetMapping(path = "/document", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DocumentDTO> documentDto(@RequestParam("id") Long id) {
		
		Document document = documentService.findDocument(id);
		DocumentDTO dto = mapper.map(document, DocumentDTO.class);
		
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DocumentDTO>> all() {
		
		List<Document> documents = documentService.findAllDocuments();
		List<DocumentDTO> dto = documents.stream().map(element -> mapper.map(element, DocumentDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok(dto);
	}
	
	//@Valid  
	@PostMapping(path = "dto")
	public ResponseEntity<DocumentDTO> insertDto(@RequestBody DocumentDTO dtoRequest) {//@Valid 
		
		//Document document = mapper.map(dtoRequest, Document.class);
		
		//System.out.println("dtoRequest : " + dtoRequest);
		//System.out.println("document   : " + document);
		
		//Document documentResp = documentService.saveDocument(document);
		//DocumentDTO dtoResponse = mapper.map(documentResp, DocumentDTO.class);
		
		DocumentDTO dtoResponse = documentService.saveDocument(dtoRequest);
		
		return ResponseEntity.ok(dtoResponse);
	}
	
	@PutMapping(path = "dto")
	public ResponseEntity<DocumentDTO> updateDto(@RequestBody DocumentDTO dtoRequest, @RequestParam("id") Long id) {
		
		return null;
	}
	*/
}
