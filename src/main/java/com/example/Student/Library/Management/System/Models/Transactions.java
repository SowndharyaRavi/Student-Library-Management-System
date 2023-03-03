package com.example.Student.Library.Management.System.Models;

import com.example.Student.Library.Management.System.Enums.TransactionStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactionTable")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionsStatus;

    private int fine;

    private String transactionId= UUID.randomUUID().toString();

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssuedOperation;

    //connect Book class
    @ManyToOne
    @JoinColumn
    private Book book;

    //connect Card class
    @ManyToOne
    @JoinColumn
    private Card card;

    public Transactions() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatus getTransactionsStatus() {
        return transactionsStatus;
    }

    public void setTransactionsStatus(TransactionStatus transactionsStatus) {
        this.transactionsStatus = transactionsStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssuedOperation() {
        return isIssuedOperation;
    }

    public void setIssuedOperation(boolean issuedOperation) {
        isIssuedOperation = issuedOperation;
    }
}
