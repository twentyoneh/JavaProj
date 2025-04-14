package twentyoneh.learn1.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private int age;
}
