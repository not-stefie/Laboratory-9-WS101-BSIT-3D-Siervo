package com.Siervo.Lab7.repository;

import com.Siervo.Lab7.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
