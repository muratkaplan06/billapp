# Invoice_Evam-Java-Bootcamp-Bitirme-Projesi

Java, springboot, Jpa, Maven,Postman,PostgreSQL are used in this project

It can get customer and invoice information from postman and save it to database.

http://localhost:8080/api/v1/client/addNewClient it can post client information from postman to database

http://localhost:8080/api/v1/invoice/addNewInvoice it can post invoice information from postman to database

![postman](https://user-images.githubusercontent.com/62430581/180449932-14ce1081-bd47-456c-bc4f-40b3fe317b93.png)  ![post2](https://user-images.githubusercontent.com/62430581/180450187-244813a9-cea0-4575-824c-45e0d718aaca.png)

customers and invoices can be deleted, updated, new customers can be added

 ``@Query("SELECT I FROM Invoice I WHERE I.status = 0")
    Collection<Invoice> findAllUnpaidInvoice();``

this query is used for getting unpaid invoices whose satatus is 0 from database

http://localhost:8080/api/v1/invoice/unPaidInvoices

![pos3](https://user-images.githubusercontent.com/62430581/180456328-867ea1ff-a5e7-4b50-9479-efdd65f8bc42.png)
    
