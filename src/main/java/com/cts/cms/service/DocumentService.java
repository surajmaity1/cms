package com.cts.cms.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.cts.cms.dto.DocumentDto;
import com.cts.cms.entity.Document;

public interface DocumentService {
    public String uploadDocument(Long memberId,Long claimId,MultipartFile firstDocument,
                                 MultipartFile secondDocument,MultipartFile thirdDocument) throws IOException;
}