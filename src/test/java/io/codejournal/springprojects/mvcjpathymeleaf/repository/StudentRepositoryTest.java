package io.codejournal.springprojects.mvcjpathymeleaf.repository;

import com.github.javafaker.Faker;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository repository;

    @Test
    public void save_StoresRecord_WhenRecordIsValid() {
        final Student expected = new Student();
        final Faker faker = new Faker();
        expected.setFirstName(faker.name().firstName());
        expected.setLastName(faker.name().lastName());

        final Student saved = repository.save(expected);
        final Student actual = entityManager.find(Student.class, saved.getId());

        assertThat(actual).isEqualTo(expected);
    }
}
