package org.example.dto;

import lombok.Data;
import org.example.enums.EmailTheme;

@Data
public class EmailMessage {
    private String address;
    private EmailTheme theme;
    private Long statementId;
    private String text;
}
