package org.ib.was.docs.controllers;

import java.util.Set;

import org.ib.was.docs.models.Attachment;
import org.ib.was.docs.models.AttachmentData;
import org.ib.was.docs.services.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path = "/attachment", produces = MediaType.APPLICATION_JSON_VALUE)
public class AttachmentController {

	@Autowired
	private AttachmentService service;

	//@GetMapping("/files/{filename:.+}")
	@GetMapping("/files")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@RequestParam("id-att") Long id){//@PathVariable String filename) {

		System.out.println("id=" + id);

		AttachmentData loadAttachmentData = service.loadAttachmentData(id);
		Attachment attachment = loadAttachmentData.getAttachment();
		Resource resource = new ByteArrayResource(loadAttachmentData.getData());
		// return ResponseEntity.notFound().build();
		
		//return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, null).body(res);
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getName() + "\"")
                .body(resource);
	}

	@PostMapping
	public ResponseEntity<Set<Attachment>> handleFileUpload(@RequestParam("id-doc") Long id,
			@RequestParam("file") MultipartFile[] files) {

		Set<Attachment> addAttachment = service.addAttachment(id, files);

		/*
		 * for(MultipartFile file : files) { System.out.println(
		 * "------------------------------------------------------------------------------------------------------"
		 * ); System.out.println("handleFileUpload=" + file);// + " redirectAttributes="
		 * + redirectAttributes); System.out.println("getContentType=" +
		 * file.getContentType()); System.out.println("getName=" + file.getName());
		 * System.out.println("getOriginalFilename=" + file.getOriginalFilename());
		 * System.out.println("getSize=" + file.getSize());
		 * System.out.println("getResource=" + file.getResource().getFilename());
		 * System.out.println("isEmpty=" + file.isEmpty()); }
		 */
		return ResponseEntity.ok(addAttachment);
	}
	/*-
	 @ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
	 */
}
