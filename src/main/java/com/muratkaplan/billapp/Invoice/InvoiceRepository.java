package com.muratkaplan.billapp.Invoice;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    @Query("SELECT f FROM Invoice f WHERE f.client=?1")
    Optional<Invoice> findClientId(int clientId);
    @Query("SELECT I FROM Invoice I WHERE I.status = 0")
    Collection<Invoice> findAllUnpaidInvoice();
}
