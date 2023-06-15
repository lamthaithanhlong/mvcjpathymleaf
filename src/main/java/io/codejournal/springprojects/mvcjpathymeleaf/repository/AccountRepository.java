package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<User,String> {
}
