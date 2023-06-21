package io.codejournal.springprojects.mvcjpathymeleaf.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

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
    @Column(nullable = false, unique = true)
    @NotNull(message = "accountNumber is required")
    private String accountNumber;
    @Column(nullable = false)
    @NotNull(message = "customerName is required")
    private String customerName;
    @Column(nullable = false)
    @NotNull(message = "accountType is required")
    private String accountType;
    @Column(nullable = false)
    @NotNull(message = "balance is required")
    private Double balance;
    @Column(nullable = false)
    @NotNull(message = "lastTransactionDate is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastTransactionDate;
    @Column(nullable = false)
    @NotNull(message = "Appointment Date is required")
    @DateTimeFormat(pattern = "hh:mm:ss")
    private LocalTime lastTransactionTime;

    public Account(String accountNumber, String customerName, String accountType, Double balance, LocalDate lastTransactionDate, LocalTime lastTransactionTime) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.lastTransactionDate = lastTransactionDate;
        this.lastTransactionTime = lastTransactionTime;
    }

    @Transient
    private Boolean dormantAccounts;

    public boolean getDormantAccounts() {
        return isDormantAccounts();
    }
    public void setDormantAccounts(Boolean dormantAccounts) {
        if (isDormantAccounts()) {
            this.dormantAccounts = true;
        } else {
            this.dormantAccounts = false;
        }
    }
    public boolean isDormantAccounts() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthBefore = today.minusMonths(1);
        return (lastTransactionDate.isBefore(oneMonthBefore));
    }

    @Transient
    private Boolean activeAccounts;

    public boolean getActiveAccounts() {
        return isActiveAccounts();
    }
    public void setActiveAccounts(Boolean activeAccounts) {
        if (isDormantAccounts()) {
            this.activeAccounts = true;
        } else {
            this.activeAccounts = false;
        }
    }
    public boolean isActiveAccounts() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthBefore = today.minusMonths(1);
        return (lastTransactionDate.isAfter(oneMonthBefore));
    }


}
