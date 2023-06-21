package io.codejournal.springprojects.mvcjpathymeleaf.controller;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AccountService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountResponseDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ={"/ezbank/api/account"})
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value={"/dormant/list"})
    public ResponseEntity<List<AccountResponseDTO>> getAllDomaintAccount() {
        return ResponseEntity.ok(accountService.getAllDomaintAccount());
    }

    @GetMapping(value={"/active/list"})
    public ResponseEntity<List<AccountResponseDTO>> getAllActiveAccount() {
        return ResponseEntity.ok(accountService.getAllActiveAccount());
    }

    @PostMapping(value = {"/new"})
    public ResponseEntity<AccountResponseDTO> registerNewAccount(@RequestBody AccountRequestDTO AccountRequestDTO) {
        return new ResponseEntity<AccountResponseDTO>(accountService.registerNewAccount(AccountRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = {"/totalBalance"})
    public ResponseEntity<Object> getTotalAmounts() {
        Double totalAmounts = 0.0;

        List<AccountResponseDTO> accounts = accountService.getAllAccount();
        for (AccountResponseDTO a: accounts)
            totalAmounts += a.balance();
        Map<String, Object> response = new HashMap<>();
        response.put("totalBankBalance", totalAmounts);
        return ResponseEntity.ok(response);
    }
}
