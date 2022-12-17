package org.ib.was.docs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonPropertyOrder({"id", "name"})
@Getter
@Setter
@ToString
public class CustomerDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	//@ToString.Exclude
	
	public CustomerDTO() {
		// TODO Auto-generated constructor stub
	}

}
