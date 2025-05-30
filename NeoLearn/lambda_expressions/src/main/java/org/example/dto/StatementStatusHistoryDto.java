package org.example.dto;

import lombok.Data;
import org.example.enums.ChangeType;
import org.example.enums.StatementStatus;

import java.time.LocalDateTime;

@Data
public class StatementStatusHistoryDto {
    private StatementStatus status;
    private LocalDateTime time;
    private ChangeType changeType;
}
