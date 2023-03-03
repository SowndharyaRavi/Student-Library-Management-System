package com.example.Student.Library.Management.System.Services;

import com.example.Student.Library.Management.System.DTOs.IssueBookRequestDTO;
import com.example.Student.Library.Management.System.Enums.CardStatus;
import com.example.Student.Library.Management.System.Enums.TransactionStatus;
import com.example.Student.Library.Management.System.Models.Book;
import com.example.Student.Library.Management.System.Models.Card;
import com.example.Student.Library.Management.System.Models.Transactions;
import com.example.Student.Library.Management.System.Repositories.BookRepository;
import com.example.Student.Library.Management.System.Repositories.CardRepository;
import com.example.Student.Library.Management.System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception{
        int bookId= issueBookRequestDTO.getBookId();
        int cardId= issueBookRequestDTO.getCardId();

        Book book=bookRepository.findById(bookId).get();
        Card card=cardRepository.findById(cardId).get();

        Transactions transaction=new Transactions();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssuedOperation(true);
        transaction.setTransactionsStatus(TransactionStatus.PENDING);

        if(book==null || book.isIssued()==true){
           transaction.setTransactionsStatus(TransactionStatus.FAILED);
           transactionRepository.save(transaction);
           throw new Exception("Book is not Available");
        }

        if(card==null || card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionsStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Valid");
        }


        transaction.setTransactionsStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);

        //btw the book and transaction class - bidirectional
        List<Transactions> listOfTransactionForBook=book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransactions(listOfTransactionForBook);

        //btw book and card
        List<Book>issuedBookForCard=card.getBooksIssued();
        issuedBookForCard.add(book);
        card.setBooksIssued(issuedBookForCard);

        //btw card and transaction - bidirectional (-in the parent class)
        List<Transactions> transactionListForCard=card.getListOfTransaction();
        transactionListForCard.add(transaction);
        card.setListOfTransaction(transactionListForCard);

        //save the parent
        cardRepository.save(card);
        //automatically by cascading - book and transaction will be saved by saving the parent

        return "Book issued Successfully";
    }

    public String getTransactions(int bookId,int cardId){
        List<Transactions> transactionsList=transactionRepository.getTransactionListForBookAndCard(bookId,cardId);

        String transactionId=transactionsList.get(0).getTransactionId();

        return transactionId;
    }
}
