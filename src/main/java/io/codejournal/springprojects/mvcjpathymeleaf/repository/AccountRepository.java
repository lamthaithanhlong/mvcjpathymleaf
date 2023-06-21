package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
}
