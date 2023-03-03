package com.example.Student.Library.Management.System.Controllers;

import com.example.Student.Library.Management.System.DTOs.StudentMobileUpdateDTO;
import com.example.Student.Library.Management.System.Models.Student;
import com.example.Student.Library.Management.System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/getStudent")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.getNameByEmail(email);
    }

    @PutMapping("/updateMobileNo")
    public String updateMobileNo(@RequestBody StudentMobileUpdateDTO studentMobileUpdateDTO){
         return studentService.updateMobileNo(studentMobileUpdateDTO);
    }
}
