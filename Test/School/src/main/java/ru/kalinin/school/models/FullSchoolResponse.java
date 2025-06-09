package ru.kalinin.school.models;

import lombok.*;
import ru.kalinin.student.models.Student;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {

    private String name;
    private String email;
    List<Student> students;
}