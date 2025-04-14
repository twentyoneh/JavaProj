package twentyoneh.learn1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twentyoneh.learn1.model.Student;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

        public List<Student> finAllStudents()
        {
            return List.of(
                Student.builder().firstName("Dima").email("didiwot@yandex.ru").age(20).build(),
                Student.builder().firstName("Vasya").email("123didiwot@yandex.ru").age(25).build(),
                Student.builder().firstName("Katya").email("321didiwot@yandex.ru").age(31).build()
            )
        }
}
