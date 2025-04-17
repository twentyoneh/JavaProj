package twentyoneh.learn1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import twentyoneh.learn1.model.Student;


public interface StudentService {

    public List<Student> finAllStudents();
    Student saveStudent(Student student);
    Student findByEmail(String email);
    Student UpdateStudent(Student student);
    void deleteStudent(String email);
 }
