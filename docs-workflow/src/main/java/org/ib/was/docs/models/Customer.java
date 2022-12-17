package org.ib.was.docs.models;

import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
@Table(name = "CUSTOMERS_TAB")
public class Customer {

	@Id
	@TableGenerator(name = "customer_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "CUS")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@JsonBackReference
	@OneToMany(mappedBy = "customer")
	//@OrderColumn()
	//@Persister(impl = CollectionPersister.class)
	private Set<Document> documents;
	
	public Customer() {
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
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}

}
