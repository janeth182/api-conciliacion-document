package com.conciliacion.document.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conciliacion.document.entity.PendingDocument;
@Repository
public interface PendingDocumentRepository  extends JpaRepository<PendingDocument, Integer>{
	List<PendingDocument>findByClientDocNumber(String clientDocNumber, Pageable page);
}
