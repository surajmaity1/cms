package com.cts.cms.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cts.cms.dto.DocumentDto;
import com.cts.cms.service.DocumentService;

@RestController
@RequestMapping("/cms/document")
public class DocumentController {
    DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public String uploadDocument(
            @RequestParam(value = "memberId") Long memberId,
            @RequestParam(value = "claimId") Long claimId,
            @RequestParam(value = "firstDocument") MultipartFile firstDocument,
            @RequestParam(value = "secondDocument") MultipartFile secondDocument,
            @RequestParam(value = "thirdDocument") MultipartFile thirdDocument
    )  throws IOException{

        String response = documentService
                .uploadDocument(memberId, claimId, firstDocument, secondDocument, thirdDocument);
        return response;
    }
}
