package io.codejournal.springprojects.mvcjpathymeleaf;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

import static java.util.UUID.randomUUID;

@SpringBootApplication
public class MvcjpathymeleafApplication {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvcjpathymeleafApplication.class, args);
	}
	@Bean
	public ApplicationRunner initializeStudents() {
		final Student defaultStudent = new 	Student(randomUUID(), "John", "Doe");
		final Student defaultStudent1 = new Student(randomUUID(), "Linda", "Rostam");
		final Student defaultStudent2 = new Student(randomUUID(), "Tom", "Ryan");
		final Student defaultStudent3 = new Student(randomUUID(), "Jenny", "Jam");
		final Student defaultStudent4 = new Student(randomUUID(), "Jackie", "Chan");
		return args -> studentRepository.saveAll(Arrays.asList(defaultStudent, defaultStudent1, defaultStudent2, defaultStudent3, defaultStudent4));
	}
}
