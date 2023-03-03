package com.example.Student.Library.Management.System.Services;

import com.example.Student.Library.Management.System.DTOs.StudentMobileUpdateDTO;
import com.example.Student.Library.Management.System.Enums.CardStatus;
import com.example.Student.Library.Management.System.Models.Card;
import com.example.Student.Library.Management.System.Models.Student;
import com.example.Student.Library.Management.System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){

        //cardEntity
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        //studentEntity
        student.setCard(card);

        //for saving-since we're using bidirectional, we only need to save parent mthd.child mthd will be automatically saved.
        studentRepository.save(student);

        return "Student and Card created successfully";
    }

    public String getNameByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMobileNo(StudentMobileUpdateDTO studentMobileUpdateDTO){

        Student student=studentRepository.findById(studentMobileUpdateDTO.getId()).get();
        student.setMobileNo(studentMobileUpdateDTO.getMobileNo());
        studentRepository.save(student);

        return "Mobile Number updated successfully";
    }
}
