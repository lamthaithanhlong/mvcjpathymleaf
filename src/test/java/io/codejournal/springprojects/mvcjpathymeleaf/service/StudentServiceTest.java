package io.codejournal.springprojects.mvcjpathymeleaf.service;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(SpringExtension.class)
public class StudentServiceTest {
    @MockBean
    private StudentRepository repository;

    private  StudentService fixture;

    @BeforeEach
    public void setUp() {
        fixture = new StudentService(repository);
    }
    @Test
    public void getStudent_ReturnsStudent_WhenStudentExists() {
        final UUID id = randomUUID();
        final Student student = new Student(randomUUID(),randomUUID().toString(), randomUUID().toString());
        final Optional<Student> expected = Optional.of(student);
        given(repository.findById(id)).willReturn(expected);
        final Optional<Student> actual = fixture.getStudent(id);
        assertThat(actual).isEqualTo(expected);
        then(repository).should().findById(id);
        then(repository).shouldHaveNoMoreInteractions();
    }
    @Test
    public void getStudent_ReturnsStudent_WhenStudentDoesNotExist() {
        final UUID id = randomUUID();
        final Optional<Student> expected = Optional.empty();
        given(repository.findById(id)).willReturn(expected);
        final Optional<Student> actual = fixture.getStudent(id);
        assertThat(actual).isEqualTo(expected);
        then(repository).should().findById(id);
        then(repository).shouldHaveNoMoreInteractions();
    }

    public void save_ReturnSaved_WhenStudentRecordIsCreated() {
        final UUID id = randomUUID();
        final Student expected = new Student();
        expected.setFirstName(randomUUID().toString());
        expected.setLastName(randomUUID().toString());
        given(repository.save(expected)).willAnswer(invocation -> {
            final Student toSave = invocation.getArgument(0);
            toSave.setId(id);
            return toSave;
        });
    }
}
