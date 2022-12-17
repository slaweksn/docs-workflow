package org.ib.was.docs.repositories;

import java.util.List;

import org.ib.was.docs.models.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
	
	<T> List<T> findBy(Class<T> projection);
}
