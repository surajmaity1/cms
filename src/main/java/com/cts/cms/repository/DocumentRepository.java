package com.cts.cms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.cms.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{
    Optional<Document> findByMemberId(Long memberId);
    Optional<Document> findByClaimId(Long memberId);
}