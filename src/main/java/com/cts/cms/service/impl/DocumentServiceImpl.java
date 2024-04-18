package com.cts.cms.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cts.cms.dto.DocumentDto;
import com.cts.cms.entity.Document;
import com.cts.cms.repository.DocumentRepository;
import com.cts.cms.service.DocumentService;
import org.springframework.util.StringUtils;

@Service
public class DocumentServiceImpl implements DocumentService{

    DocumentRepository documentRepository;

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public String uploadDocument(Long memberId,Long claimId, MultipartFile firstDocument,
                                 MultipartFile secondDocument,MultipartFile thirdDocument)  throws IOException{
        // TODO Auto-generated method stub
        Document document = new Document();

        String firstDocumentName = StringUtils.cleanPath(firstDocument.getOriginalFilename());
        String secondDocumentName = StringUtils.cleanPath(secondDocument.getOriginalFilename());
        String thirdDocumentName = StringUtils.cleanPath(thirdDocument.getOriginalFilename());

        document.setMemberId(memberId);
        document.setClaimId(claimId);
        document.setFirstDocumentName(firstDocumentName);
        document.setSecondDocumentName(secondDocumentName);
        document.setThirdDocumentName(thirdDocumentName);
        document.setFirstDocument(firstDocument.getBytes());
        document.setSecondDocument(secondDocument.getBytes());
        document.setThirdDocument(thirdDocument.getBytes());

        documentRepository.save(document);
        return "Success: Document uploaded";
    }

}