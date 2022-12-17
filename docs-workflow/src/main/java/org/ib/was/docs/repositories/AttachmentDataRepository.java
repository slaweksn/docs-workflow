package org.ib.was.docs.repositories;

import org.ib.was.docs.models.AttachmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentDataRepository extends JpaRepository<AttachmentData, Long>{

}
