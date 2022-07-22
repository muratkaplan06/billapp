package com.muratkaplan.billapp.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

    @Service
    public class InvoiceService {
        private final InvoiceRepository invoiceRepository;

        @Autowired
        public InvoiceService(InvoiceRepository invoiceRepository) {
            this.invoiceRepository = invoiceRepository;
        }
        public List<Invoice> getInvoice(){
            return invoiceRepository.findAll();
        }
        public void addInvoice(List<Invoice> invoice) {
            /*Optional<Fatura> faturaOptional=faturaRepository.findFaturaName(fatura.getFaturaName());
            if(faturaOptional.isPresent()){
                throw new IllegalStateException("id already taken");
            }*/
            invoiceRepository.saveAll(invoice);
        }
        public  Collection<Invoice> findAllUnpaidInvoice(){
            return invoiceRepository.findAllUnpaidInvoice();
        }

        public void deleteInvoice(int id) {
            boolean exist= invoiceRepository.existsById(id);
            if(!exist){
                throw new IllegalStateException(id+" does not exist");
            }
            invoiceRepository.deleteById(id);
        }

        public void updateInvoice(int id, int client_id, int debt, LocalDate date, int status) {
            Invoice invoice = invoiceRepository.findById(id)
                    .orElseThrow(()->new IllegalStateException(id+" does not exist"));
            if(!Objects.equals(invoice.getDebt(),debt)){
                Optional<Invoice> invoiceOptional= invoiceRepository.findClientId(client_id);
                if(invoiceOptional.isPresent()){
                    throw new IllegalStateException(client_id+" is used");
                }
                invoice.setDebt(debt);
            }
            if(!Objects.equals(invoice.getStatus(),status)){
                Optional<Invoice> invoiceOptional= invoiceRepository.findClientId(client_id);
                if(invoiceOptional.isPresent()){
                    throw new IllegalStateException(client_id+" is used");
                }
                invoice.setStatus(status);
            }
        }
    }

