package io.codejournal.springprojects.mvcjpathymeleaf;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MvcjpathymeleafApplication {
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvcjpathymeleafApplication.class, args);
	}

	@Bean
	public ApplicationRunner InitializeStudents() {
		 final Student defaultStudent = new Student(1,"000-61-0001","Anna","Lynn","Smith",3.45,2019/5/24);
		 return args -> studentRepository.saveAll(Arrays.asList(defaultStudent));
	}

}
