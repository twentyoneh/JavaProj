package ru.kalinin.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kalinin.student.models.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
