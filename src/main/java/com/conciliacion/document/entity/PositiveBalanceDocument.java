package com.conciliacion.document.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "positive_balance_documents")
@EntityListeners(AuditingEntityListener.class)
public class PositiveBalanceDocument {
	@Id
    @Column(name = "id_negative_doc")
    private int idNegativeDoc;

    @Column(name = "cu")
    private String cu;

    @Column(name = "doc_type")
    private String docType;

    @Column(name = "zone")
    private String zone;

    @Column(name = "series")
    private String series;

    @Column(name = "correlation")
    private String correlation;

    @Column(name = "description")
    private String description;

    @Column(name = "customer_doc_type")
    private String customerDocType;

    @Column(name = "customer_doc_number")
    private String customerDocNumber;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "due_date")
    private String dueDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "impact_instruction")
    private String impactInstruction;

    @Column(name = "application_instruction")
    private String applicationInstruction;

    @Column(name = "currency")
    private String currency;

    @Column(name = "sub_total")
    private double subTotal;

    @Column(name = "igv")
    private double igv;

    @Column(name = "delay")
    private double delay;

    @Column(name = "total")
    private double total;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "process_date")
    private String processDate;

    @Column(name = "additional_data_one")
    private String additionalDataOne;

    @Column(name = "additional_data_two")
    private String additionalDataTwo;

    @Column(name = "additional_data_three")
    private String additionalDataThree;

    @Column(name = "cip_number")
    private String cipNumber;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
}
