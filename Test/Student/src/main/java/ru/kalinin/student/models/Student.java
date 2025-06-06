package ru.kalinin.student.models;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer schoolId;
}
