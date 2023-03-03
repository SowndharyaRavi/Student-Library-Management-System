package com.example.Student.Library.Management.System.Repositories;

import com.example.Student.Library.Management.System.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findByEmail(String email);
}
