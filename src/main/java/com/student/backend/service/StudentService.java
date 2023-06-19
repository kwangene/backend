package com.student.backend.service;

import com.student.backend.model.Student;


import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long indexNumber);
    Student updateStudent(Student student,long indexNumber);
     void deleteStudent(long indexNumber);

}
