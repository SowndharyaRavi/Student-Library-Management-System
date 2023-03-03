package com.example.Student.Library.Management.System.Repositories;

import com.example.Student.Library.Management.System.Models.Book;
import org.aspectj.lang.JoinPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
