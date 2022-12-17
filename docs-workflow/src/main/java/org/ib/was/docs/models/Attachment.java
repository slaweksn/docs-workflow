package org.ib.was.docs.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
@Entity
@Table(name = "ATTACHMENTS_TAB")
public class Attachment {

	@Id
	@TableGenerator(name = "attachment_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "ATT")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "attachment_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DATA_SIZE")
	private Long dataSize;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "DOCUMENT_IDR", nullable = false)
	private Document document;
	
	//@OneToOne(mappedBy = "attachment", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    //private AttachmentData attachmentData;
	
	public Attachment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attachment other = (Attachment) obj;
		return Objects.equals(id, other.id);
	}

}
