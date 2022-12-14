package org.ib.was.docs.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@JsonPropertyOrder({"idr", "name", "document"})
@Data
@Entity
@Table(name = "ATTACHMENTS_TAB")
public class Attachment {

	@Id
	@TableGenerator(name = "attachment_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "ATT")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "attachment_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;
	
	@JsonProperty("name")
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "DOCUMENT_IDR")
	private Document document;
	
	public Attachment() {
		// TODO Auto-generated constructor stub
	}

}
