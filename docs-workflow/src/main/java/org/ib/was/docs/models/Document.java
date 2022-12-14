package org.ib.was.docs.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@JsonPropertyOrder({"idr", "name", "customer", "attachments"})
@Data
@Entity
@Table(name = "DOCUMENTS_TAB")
public class Document {
	
	@JsonProperty("id")
	@Id
	@TableGenerator(name = "doc_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "DOC")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "doc_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;
	
	@JsonProperty("name")
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@JsonManagedReference
	@JsonProperty("customer")
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_IDR")
	private Customer customer;
	
	@JsonManagedReference
	@JsonProperty("attachments")
	@OneToMany(mappedBy = "document")
	private List<Attachment> attachments;
	
	public Document() {
		// TODO Auto-generated constructor stub
	}

}
