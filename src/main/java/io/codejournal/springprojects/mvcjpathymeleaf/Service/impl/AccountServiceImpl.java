package io.codejournal.springprojects.mvcjpathymeleaf.Service.impl;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AccountService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountResponseDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Account;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountResponseDTO> getAllDomaintAccount() {
        return accountRepository.findAll()
                .stream()
                .filter(Account::isDormantAccounts)
                .sorted(Comparator.comparing(Account::getCustomerName))
                .map(account -> new AccountResponseDTO(
                        account.getAccountId(),
                        account.getAccountNumber(),
                        account.getCustomerName(),
                        account.getAccountType(),
                        account.getBalance(),
                        account.getLastTransactionDate(),
                        account.getLastTransactionTime()
                )).toList();
    }

    @Override
    public List<AccountResponseDTO> getAllActiveAccount() {
        return accountRepository.findAll()
                .stream()
                .filter(Account::isActiveAccounts)
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .map(account -> new AccountResponseDTO(
                        account.getAccountId(),
                        account.getAccountNumber(),
                        account.getCustomerName(),
                        account.getAccountType(),
                        account.getBalance(),
                        account.getLastTransactionDate(),
                        account.getLastTransactionTime()
                )).toList();
    }

    @Override
    public AccountResponseDTO registerNewAccount(AccountRequestDTO patientRequestDTO) {
        var account = new Account(
                patientRequestDTO.accountNumber(),
                patientRequestDTO.customerName(),
                patientRequestDTO.accountType(),
                patientRequestDTO.balance(),
                patientRequestDTO.lastTransactionDate(),
                patientRequestDTO.lastTransactionTime()
        );
        var newAccount = accountRepository.save(account);
        return new AccountResponseDTO(
                newAccount.getAccountId(),
                newAccount.getAccountNumber(),
                newAccount.getCustomerName(),
                newAccount.getAccountType(),
                newAccount.getBalance(),
                newAccount.getLastTransactionDate(),
                newAccount.getLastTransactionTime()
        );
    }


}
