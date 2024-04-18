package com.cts.cms.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "claim_id", nullable = false)
    private Long claimId;

    @Column(name = "first_document_name", nullable = false)
    private String firstDocumentName;

    @Column(name = "second_document_name", nullable = false)
    private String secondDocumentName;

    @Column(name = "third_document_name", nullable = false)
    private String thirdDocumentName;

    @Lob
    @Column(name = "first_document", length = 16777215, nullable = false)
    private byte[] firstDocument;

    @Lob
    @Column(name = "second_document", length = 16777215, nullable = false)
    private byte[] secondDocument;

    @Lob
    @Column(name = "third_document", length = 16777215, nullable = false)
    private byte[] thirdDocument;

}