package org.ib.was.docs.models;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "DOCUMENTS_TAB")
public class Document {

	@JsonProperty("id")
	@Id
	@TableGenerator(name = "doc_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "DOC", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "doc_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;

	@JsonProperty("name")
	@Column(name = "NAME", nullable = false)
	private String name;

	//@JsonManagedReference
	@JsonProperty("customer")
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "CUSTOMER_IDR")
	private Customer customer;

	// @ToString.Exclude
	//@JsonManagedReference
	@JsonProperty("attachments")
	@OneToMany(mappedBy = "document", targetEntity = Attachment.class, cascade = CascadeType.ALL)
	// @OrderBy()
	private Set<Attachment> attachments;

	public Document() {
		// TODO Auto-generated constructor stub
	}

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
		Document other = (Document) obj;
		return Objects.equals(id, other.id);
	}

}
