package org.ib.was.docs.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
@Table(name = "ATTACHMENT_TAB")
public class Attachment {

	@Id
	@TableGenerator(name = "attachment_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "ATT")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "attachment_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;
	
	@ManyToOne
	private Document document;
	
	public Attachment() {
		// TODO Auto-generated constructor stub
	}

}
