package com.muratkaplan.billapp.payment;

import com.muratkaplan.billapp.Client.Client;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table
public class Payment {
    @Id
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private int id;
    private int client_id;
    private int paidTotal;
    private LocalDate date;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id",referencedColumnName = "id",insertable=false, updatable=false)
    private Client client;

    public Payment() {
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public int getId() {
        return id;
    }

    public int getClient_id() {
        return client_id;
    }

    public int getPaidTotal() {
        return paidTotal;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public void setPaidTotal(int paidTotal) {
        this.paidTotal = paidTotal;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
