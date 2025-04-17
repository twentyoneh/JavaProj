package twentyoneh.learn1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import twentyoneh.learn1.model.Student;

@Repository
public class InMemoryStudentDAO {
    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> finAllStudents()
    {
        return STUDENTS;
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return STUDENTS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student UpdateStudent(Student student) {
        var studentIndex = IntStream.range(0,  STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if(studentIndex > -1) {
            STUDENTS.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if(student != null) {
            STUDENTS.remove(student);
        }
    }
}
