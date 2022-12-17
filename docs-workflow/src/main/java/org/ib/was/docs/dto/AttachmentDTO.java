package org.ib.was.docs.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id", "name"})
@Getter
@Setter
@ToString
public class AttachmentDTO {

	private Long id;

	private String name;
	
	public AttachmentDTO() {
		// TODO Auto-generated constructor stub
	}

}
