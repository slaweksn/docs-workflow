package org.ib.was.docs.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ATTACHMENTS_DATA_TAB")
public class AttachmentData {
	
	@Id
	@Column(name = "ATTACHMENT_IDR")
	private Long id;
	
	@JsonBackReference
	@OneToOne
	@MapsId
	@JoinColumn(name = "ATTACHMENT_IDR")
	private Attachment attachment;
	
	@Lob
	@Column(name = "DATA")
	//private Blob data;
	private byte[] data;

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttachmentData other = (AttachmentData) obj;
		return Objects.equals(id, other.id);
	}
	
}
