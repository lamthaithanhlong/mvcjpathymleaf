package io.codejournal.springprojects.mvcjpathymeleaf.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AccountResponseDTO(
        Long accountId,
        String accountNumber,
        String customerName,
        String accountType,
        Double balance,
        LocalDate lastTransactionDate,
        LocalTime lastTransactionTime) {
}
