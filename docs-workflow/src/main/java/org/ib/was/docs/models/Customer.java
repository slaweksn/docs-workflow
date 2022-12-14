package org.ib.was.docs.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@JsonPropertyOrder({"idr", "name", "documents"})
@Data
@Entity
@Table(name = "CUSTOMERS_TAB")
public class Customer {

	@Id
	@TableGenerator(name = "customer_gen", table = "DOCS_TABLE_NUM_GEN", schema = "dbo", valueColumnName = "IDR_VALUE", pkColumnName = "IDR_KEY", pkColumnValue = "CUS")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "customer_gen")
	@Column(name = "IDR", nullable = false, unique = true)
	private Long id;
	
	@JsonProperty("name")
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@JsonBackReference
	@OneToMany(mappedBy = "customer")
	private Set<Document> documents;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
