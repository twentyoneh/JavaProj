package twentyoneh.learn1.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import twentyoneh.learn1.model.Student;
import twentyoneh.learn1.service.StudentService;
import twentyoneh.learn1.repository.InMemoryStudentDAO;

@Service
@AllArgsConstructor
public class InMemoryStudentServiceImpl implements StudentService {

    private final InMemoryStudentDAO repository;

    @Override
    public List<Student> finAllStudents()
    {
        return repository.finAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student UpdateStudent(Student student) {
        return repository.UpdateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}
