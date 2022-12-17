package org.ib.was.docs.services;

import java.util.List;
import java.util.Optional;

import org.ib.was.docs.dto.DocumentDTO;
import org.ib.was.docs.dto.DocumentView;
import org.ib.was.docs.models.Document;
import org.ib.was.docs.repositories.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private ModelMapper mapper;
	
	public List<Document> findAllDocuments() {

		return documentRepository.findAll();
	}

	public List<DocumentView> findAllDocumentsView() {
		
		return documentRepository.findBy(DocumentView.class);
	}
	
	public Document findDocument(Long id) {

		return documentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("document not found exception"));
	}

	@Transactional
	public Document saveDocument(Document document) {
		
		return documentRepository.save(document);
	}
	
	
	@Transactional
	public DocumentDTO saveDocument(DocumentDTO documentDto) {
		
		
		Document documentFromDto = mapper.map(documentDto, Document.class);
		System.out.println("SAVE: " + documentFromDto);
		
		if(documentFromDto.getId() == null) {
			
			Document document2 = documentRepository.save(documentFromDto);
			
			return mapper.map(document2, DocumentDTO.class);
		} else {
			Optional<Document> optionalDocument = documentRepository.findById(documentFromDto.getId());
			
			if(optionalDocument.isPresent()) {
				Document document = optionalDocument.get();
				
				return mapper.map(document, DocumentDTO.class);
			} else {
				throw new RuntimeException("error save");
			}
		}
		
	}
}
