package com.student.backend.service;

import com.student.backend.exception.ResourceNotFoundException;
import com.student.backend.model.Student;
import com.student.backend.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public  Student getStudentById(long indexNumber)  {
        return studentRepository.findById(indexNumber).orElseThrow(()->
                new ResourceNotFoundException("Student","IndexNumber",indexNumber));
    }

    @Override
    public Student updateStudent(Student student, long indexNumber) {
        // we need to check if the student with this index# is present in the Db;
        Student existingStudent = studentRepository.findById(indexNumber).orElseThrow(()->
                              new ResourceNotFoundException("Student","IndexNumber",indexNumber));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //Save the existing Student to the Db
        studentRepository.save(existingStudent);

        return existingStudent;
    }

    @Override
    public void deleteStudent(long indexNumber) {
        studentRepository.findById(indexNumber).orElseThrow(()->new
                                              ResourceNotFoundException("Student","indexNumber",indexNumber));
        studentRepository.deleteById(indexNumber);
    }
}
