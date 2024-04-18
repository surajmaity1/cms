package com.cts.cms.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDto {
    private Long memberId;
    private Long claimId;
    private byte[] firstDocument;
    private byte[] secondDocument;
    private byte[] thirdDocument;
}