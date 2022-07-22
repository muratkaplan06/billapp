package com.muratkaplan.billapp.Invoice;

import com.muratkaplan.billapp.Client.Client;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Invoice {
    @Id
    @SequenceGenerator(
            name = "invoice_sequence",
            sequenceName = "invoice_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice_sequence"
    )
    private int id;
    @ManyToOne
    @JoinColumn(name="client_id",nullable=false,insertable=false, updatable=false)
    private Client client;
    private int status;
    private int debt;
    private LocalDate date;
    private int client_id;

    public Invoice() {
    }

    public Invoice(int debt, LocalDate date,int status,int client_id) {
        this.debt = debt;
        this.date = date;
        this.status=status;
        this.client_id=client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public int getDebt() {
        return debt;
    }

    public LocalDate getDate() {
        return date;
    }
}