package io.codejournal.springprojects.mvcjpathymeleaf.controller;

import io.codejournal.springprojects.mvcjpathymeleaf.Service.AccountService;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
