package org.ib.was.docs.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.ib.was.docs.models.Attachment;
import org.ib.was.docs.models.AttachmentData;
import org.ib.was.docs.models.Document;
import org.ib.was.docs.repositories.AttachmentDataRepository;
import org.ib.was.docs.repositories.AttachmentRepository;
import org.ib.was.docs.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AttachmentService {

	@Autowired
	private AttachmentRepository repository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private AttachmentDataRepository attachmentDataRepository;
	
	@Transactional
	public Set<Attachment> addAttachment(Long id, MultipartFile[] files) {

		Optional<Document> documentOptional = documentRepository.findById(id);

		if (documentOptional.isPresent()) {
			Document document = documentOptional.get();

			try {
				Set<Attachment> results = new HashSet<>();
				
				for(MultipartFile file : files) {
					
					System.out.println("addAttachment=" + file.getOriginalFilename());
					Attachment attachment = new Attachment();
					attachment.setDocument(document);
					attachment.setName(file.getOriginalFilename());
					attachment.setDataSize(file.getSize());
					//attachment.setData(file.getBytes());
					//attachment.setData(BlobProxy.generateProxy(file.getBytes()));
					//attachment.setData(new SerialBlob(file.getBytes()));
					attachment.setContentType(file.getContentType());
					Attachment attachmentResponse = repository.save(attachment);
					
					AttachmentData attachmentData = new AttachmentData();
					attachmentData.setAttachment(attachmentResponse);
					attachmentData.setData(file.getBytes());
					attachmentDataRepository.save(attachmentData);
					
					
					
					results.add(attachmentResponse);
				}
				
				return results;
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}

		} else {
			throw new EntityNotFoundException("Document not found");
		}

	}

	public AttachmentData loadAttachmentData(Long id) {
		/*
		Optional<AttachmentData> attachmentDataOptional = attachmentDataRepository.findById(id);
		if(attachmentDataOptional.isPresent()) {
			attachmentDataOptional.get
			Resource resource = new ByteArrayResource(array);
		} else {
			
		}
		
		
		return resource;
		*/
		//return new ByteArrayResource(attachmentDataRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Attachment not found")).getData());
		return attachmentDataRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Attachment not found"));
		//return null;
	}
}
