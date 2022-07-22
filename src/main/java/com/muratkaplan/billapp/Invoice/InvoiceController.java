package com.muratkaplan.billapp.Invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


     @RestController
     @RequestMapping("api/v1/invoice")
    public class InvoiceController {
        private final InvoiceService invoiceService;
        @Autowired
        public InvoiceController(InvoiceService invoiceService) {
            this.invoiceService = invoiceService;
        }
        @GetMapping
        public List<Invoice> getInvoice(){return invoiceService.getInvoice();}
         //http://localhost:8080/api/v1/invoice/unPaidInvoices statüsü 0 olan odenmemis faturaları
         //faturayı odemeyenlerin bilgisini getirir.
        @GetMapping("/unPaidInvoices")
        public Collection<Invoice> findAllUnpaidInvoice(){
            return invoiceService.findAllUnpaidInvoice();
        }
       //http://localhost:8080/api/v1/fatura/addNewFatura adresinde postmanden fatura bilgisi alıyor
       //liste şeklinde postmanden bilgi alıyor.
       @PostMapping("/addNewInvoice")
        public void registerNewInvoice(@RequestBody List<Invoice> invoice){
        invoiceService.addInvoice(invoice);
        }
       //silme işlemi
       @DeleteMapping(path = "{invoiceId}")
       public void deleteInvoice(@PathVariable("invoiceId") int invoiceId){
        invoiceService.deleteInvoice(invoiceId);}
       //Güncelleme
       /*@PutMapping(path = "{invoiceId}")
        public void updateInvoice(
               @PathVariable("{invoiceId}") int invoiceId,
               @RequestParam(required = false) int client_id,
               @RequestParam(required = false) int debt,
               @RequestParam(required = false) LocalDate date,
               @RequestParam(required = false) int status){
            invoiceService.updateInvoice(invoiceId,client_id,debt,date,status);
            }*/

   }

