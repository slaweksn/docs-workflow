package org.ib.was.docs.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id", "name", "customerId", "customerName", "attachments"})
@Getter
@Setter
@ToString
public class DocumentDTO {

	private Long id;

	private String name;

	@JsonProperty("customer-id")
	private Long customerId;
	
	@JsonProperty("customer-name")
	private String customerName;
	
	@JsonProperty("attachments")
	private Set<AttachmentDTO> attachments;
	
	public DocumentDTO() {
		// TODO Auto-generated constructor stub
	}

}
