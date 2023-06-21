package io.codejournal.springprojects.mvcjpathymeleaf.Service;

import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountRequestDTO;
import io.codejournal.springprojects.mvcjpathymeleaf.dto.AccountResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<AccountResponseDTO> getAllDomaintAccount();

    List<AccountResponseDTO> getAllActiveAccount();

    List<AccountResponseDTO> getAllAccount();

    AccountResponseDTO registerNewAccount(AccountRequestDTO accountRequestDTO);
}
