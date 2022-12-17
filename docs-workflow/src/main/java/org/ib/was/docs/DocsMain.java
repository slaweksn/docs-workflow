package org.ib.was.docs;

import java.util.HashSet;
import java.util.Set;

import org.ib.was.docs.configs.MapperDTO;
import org.ib.was.docs.dto.DocumentDTO;
import org.ib.was.docs.models.Attachment;
import org.ib.was.docs.models.Customer;
import org.ib.was.docs.models.Document;
import org.modelmapper.ModelMapper;

public class DocsMain {

	public DocsMain() {
		// TODO Auto-generated constructor stub
		testMapDTO();
	}

	private void testMapDTO() {
		// TODO Auto-generated method stub
		MapperDTO mapperDTO = new MapperDTO();
		
		
		ModelMapper modelMapper = mapperDTO.modelMapper();
		
		
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
		
		DocumentDTO documentDTO = modelMapper.map(document1, DocumentDTO.class);
		System.out.println(documentDTO);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DocsMain();
	}

}
