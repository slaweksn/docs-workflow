package org.ib.was.docs.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "DOCS_TABLE_NUM_GEN")
public class TableNumeratorID {

	@Id
	@Column(name = "IDR_KEY", nullable = false, unique = true)
	private String id;
	
	@Column(name = "IDR_VALUE", nullable = false, unique = true)
	private Long value;

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
		TableNumeratorID other = (TableNumeratorID) obj;
		return Objects.equals(id, other.id);
	}
}
