package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import com.github.javafaker.Faker;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository repository;

    @Test
    public void save_StoreRecord_WhenRecordIsValid() {
        final User expected = new User();
        Faker faker = new Faker();
        expected.setUsername(faker.name().username());
        expected.setPassword(faker.internet().password());

        final User saved = repository.save(expected);
        final User actual = entityManager.find(User.class, saved.getUsername());

        assertThat(actual).isEqualTo(expected);
    }
}
