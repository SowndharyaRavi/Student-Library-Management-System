package com.example.Student.Library.Management.System.Repositories;

import com.example.Student.Library.Management.System.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {

    @Query(value = "select * from transaction_table t where t.book_id=:bookId and t.card_id=:cardId and is_issued_operation=true"
    , nativeQuery = true)
    List<Transactions> getTransactionListForBookAndCard(int bookId,int cardId);
}
