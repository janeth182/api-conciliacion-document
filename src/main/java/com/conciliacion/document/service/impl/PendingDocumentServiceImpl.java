package com.conciliacion.document.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.conciliacion.document.entity.PendingDocument;
import com.conciliacion.document.repository.PendingDocumentRepository;
import com.conciliacion.document.service.PendingDocumentService;

@Service
public class PendingDocumentServiceImpl implements PendingDocumentService {

	@Autowired
	private PendingDocumentRepository repository;

	@Override
	public String fileProcessor(String data, String fileName) {
		try {
			List<PendingDocument> listDocuments = new ArrayList<>();
			data.lines().forEach((item)->{
				if(item.length() > 53) {												
					 PendingDocument nuevo = new PendingDocument();
					 nuevo.setCu(item.substring(0,19).trim());
					 nuevo.setDocType(item.substring(20,21).trim());			
					 nuevo.setZone(item.substring(22,26).trim());	
					 nuevo.setSeries(item.substring(27,34).trim());
					 nuevo.setCorrelation(item.substring(35,54).trim());
					 nuevo.setDescription(item.substring(55,154).trim());
					 nuevo.setClientDocType(item.substring(155,155).trim());
					 nuevo.setClientDocNumber(item.substring(156,175).trim());
					 nuevo.setCompanyName(item.substring(176,315).trim());
					 nuevo.setIssueDate(item.substring(316,323).trim());
					 nuevo.setDueDate(item.substring(324,331).trim());
					 nuevo.setReason(item.substring(332,371).trim());
					 nuevo.setReferenceNumber(item.substring(372,387).trim());
					 nuevo.setAffectationInstruction(item.substring(388, 389).trim());
					 nuevo.setApplicationInstruction(item.substring(390, 439).trim());
					 nuevo.setCurrency(item.substring(440,442).trim());
					 nuevo.setSubTotal(Double.parseDouble(item.substring(443,462).trim()));
					 nuevo.setIgv(Double.parseDouble(item.substring(463,482).trim()));					
					 nuevo.setDelay(Double.parseDouble(item.substring(483,502).trim()));
					 nuevo.setTotal(Double.parseDouble(item.substring(503,522).trim()));	
					 nuevo.setDetraction(Double.parseDouble(item.substring(523,542).trim()));
					 nuevo.setProcessDate(item.substring(543, 556).trim());
					 nuevo.setProcessUser(item.substring(557, 571).trim());
					 nuevo.setAdditionalDataOne(item.substring(574, 593).trim());
					 nuevo.setAdditionalDataTwo(item.substring(594, 613).trim());
					 nuevo.setAdditionalDataThree(item.substring(614, 633).trim());
					 nuevo.setAdditionalDataFour(item.substring(634, 653).trim());
					 nuevo.setAdditionalDataFive(item.substring(654, 673).trim());
					 nuevo.setAdditionalDataSix(item.substring(674, 693).trim());
					 listDocuments.add(nuevo);
				}
			}); 
			repository.saveAll(listDocuments);
			return null;
		} catch (Exception e) {
			 System.out.println(e.getMessage());
			return e.getMessage();
		}		
	}

	@Override
	public List<PendingDocument> findByClientDocNumber(String clientDocNumber, Pageable page) {
		try {
			return repository.findByClientDocNumber(clientDocNumber, page);
		} catch (Exception e) {
			return null;
		}
	}	
}
