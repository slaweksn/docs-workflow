package org.ib.was.docs.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.ib.was.docs.configs.MapperDTO;
import org.ib.was.docs.models.Attachment;
import org.ib.was.docs.models.Customer;
import org.ib.was.docs.models.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MapperDTOTest {
	//https://howtodoinjava.com/spring-boot2/testing/spring-boot-2-junit-5/
	
	@Autowired
	private MapperDTO mapper;
	
	@Test
	public void when_MapperDTO_Document_WithExactMatch_then_ConvertsTo_DocumentDTO() {
		
		Document document1 = new Document();
		document1.setId(1l);
		document1.setName("document_01");

		Customer customer1 = new Customer();
		customer1.setId(2l);
		customer1.setName("customer_01");
		document1.setCustomer(customer1);

		Attachment attachment1 = new Attachment();
		attachment1.setId(1l);
		attachment1.setName("plik_01.txt");
		
		
		Attachment attachment2 = new Attachment();
		attachment2.setId(2l);
		attachment2.setName("plik_02.txt");
		Set<Attachment> set = new HashSet<>();
		set.add(attachment1);
		set.add(attachment2);
		document1.setAttachments(set);
		
		
		DocumentDTO documentDTO = this.mapper.modelMapper().map(document1, DocumentDTO.class);
		System.out.println(documentDTO);
		
		assertEquals(document1.getId(), documentDTO.getId());
	    assertEquals(document1.getName(), documentDTO.getName());
	    assertEquals(document1.getCustomer().getId(), documentDTO.getCustomerId());
	    assertEquals(document1.getCustomer().getName(), documentDTO.getCustomerName());
	    
	    
	}
}
