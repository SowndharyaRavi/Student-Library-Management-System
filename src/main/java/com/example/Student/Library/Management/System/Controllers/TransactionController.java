package com.example.Student.Library.Management.System.Controllers;

import com.example.Student.Library.Management.System.DTOs.IssueBookRequestDTO;
import com.example.Student.Library.Management.System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO){
        try {
            return transactionService.issueBook(issueBookRequestDTO);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getTransactionId")
    public String getTransactions(@RequestParam("bookId") Integer bookId, @RequestParam("cardId") Integer cardId){
        return transactionService.getTransactions(bookId,cardId);
    }
}
