package com.conciliacion.document.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.conciliacion.document.entity.PendingDocument;
import com.conciliacion.document.service.PendingDocumentService;



@RestController
@RequestMapping("/v1/pending-document")
public class PendingDocumentController {
	@Autowired
	private PendingDocumentService service;
	
	@GetMapping
	public ResponseEntity<List<PendingDocument>> findPendingDocument(
			@RequestParam(value="clientNumber", required = false, defaultValue = "") String clientNumber,
			@RequestParam(value="offset", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "limit",required = false,defaultValue = "5") int pageSize
			){
		
		Pageable page=PageRequest.of(pageNumber,pageSize);
		List<PendingDocument> pendingDocument;
		pendingDocument=service.findByClientDocNumber(clientNumber, page);
		if(pendingDocument.size() > 0) {
			return ResponseEntity.ok(pendingDocument);	
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping()
	public String fileprocessor(@RequestParam("file") MultipartFile file){		
		try {
			String fileName = file.getName();
            byte[] fileContent = file.getBytes();           
            String data = new String(fileContent, "UTF-8");
            service.fileProcessor(data, fileName);                        
            return "Archivo cargado exitosamente";
        } catch (IOException e) {           
            return "Error al leer el archivo";
        }
	}
	
}
