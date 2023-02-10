package com.example.springboot.outcall.db.repository;

import com.example.springboot.outcall.db.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {}
