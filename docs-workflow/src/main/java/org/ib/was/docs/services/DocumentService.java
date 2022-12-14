package org.ib.was.docs.services;

import java.util.List;

import org.ib.was.docs.models.Document;
import org.ib.was.docs.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository documentRepository;
	
	public DocumentService() {
		// TODO Auto-generated constructor stub
	}

	public List<Document> getaAllDocuments(){
		
		return documentRepository.findAll();
	}
}
