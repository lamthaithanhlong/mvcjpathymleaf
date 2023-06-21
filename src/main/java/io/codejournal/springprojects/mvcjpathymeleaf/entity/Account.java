package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(nullable = false)
    @NotNull(message = "accountName is required")
    private String accountName;
    @Column(nullable = false)
    @NotNull(message = "customerName is required")
    private String customerName;
    @Column(nullable = false)
    @NotNull(message = "accountType is required")
    private String accountType;
    @Column(nullable = false)
    @NotNull(message = "balance is required")
    private int balance;
    @Column(nullable = false)
    @NotNull(message = "lastTransactionDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastTransactionDate;
    @Column(nullable = false)
    @NotNull(message = "Appointment Date is required")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalDate lastTransactionTime;
}
