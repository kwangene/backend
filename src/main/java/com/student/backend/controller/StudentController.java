package com.student.backend.controller;

import com.student.backend.model.Student;
import com.student.backend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    // build create student API with HTTP post method
    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);

    }
    // build get all students API with HTTP Get method to retrieve all students in the Db
    @GetMapping()
    public List<Student> getAllStudents(){
       return studentService.getAllStudents();
    }
    // build get student by indexNumber or ID API with HTTP Get method to retrieve base on their index#
    //Example:http://localhost:8080/api/students/1
    @GetMapping("{indexNum}")
    public ResponseEntity<Student> getStudentsByIndexNumber(@PathVariable("indexNum") long indexNumber){
        return new ResponseEntity<Student>(studentService.getStudentById(indexNumber), HttpStatus.OK);
    }
   //Build update Student Rest API with PUtMapping
   //Example:http://localhost:8080/api/students/1
   @PutMapping("{indexNum}")
   public ResponseEntity<Student> updateStudent(@PathVariable("indexNum") long indexNumber,@RequestBody Student student){
       return new ResponseEntity<Student>(studentService.updateStudent(student,indexNumber), HttpStatus.OK);
   }

    //Build Delete Student Rest API with DeleteMapping
    //Example:http://localhost:8080/api/students/1
    @DeleteMapping("{indexNum}")
    public ResponseEntity<String> deleteStudent(@PathVariable("indexNum") long indexNumber){
        studentService.deleteStudent(indexNumber);
        return new ResponseEntity<String>("The Student was successfully deleted ",HttpStatus.OK) ;

    }


}
