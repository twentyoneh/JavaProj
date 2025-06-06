package ru.kalinin.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kalinin.student.models.Student;
import ru.kalinin.student.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    public final StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId){
        return repository.findAllBySchoolId(schoolId);
    }
}
