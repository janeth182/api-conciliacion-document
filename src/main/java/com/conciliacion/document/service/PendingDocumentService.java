package com.conciliacion.document.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.conciliacion.document.entity.PendingDocument;


public interface PendingDocumentService {
	public String fileProcessor (String content, String fileName);
	public List<PendingDocument>findByClientDocNumber(String clientDocNumber, Pageable page);
}
