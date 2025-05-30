package org.example.dto;

import lombok.Data;
import java.time.LocalDate;
import org.example.enums.Gender;
import org.example.enums.MaritalStatus;

@Data
public class FinishRegistrationRequestDto {
    private Gender gender;
    private MaritalStatus maritalStatus;
    private Integer dependentAmount;
    private LocalDate passportIssueDate;
    private String passportIssueBrach;
    private EmploymentDto employment;
    private String accountNumber;
}
