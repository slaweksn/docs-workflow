package org.ib.was.docs.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "DOCUMENTS_TAB")
public class Document {

	@Id
	@TableGenerator(name = "doc_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "DOC")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "doc_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "document")
	private Set<Attachment> attachments;
	
	public Document() {
		// TODO Auto-generated constructor stub
	}

}
