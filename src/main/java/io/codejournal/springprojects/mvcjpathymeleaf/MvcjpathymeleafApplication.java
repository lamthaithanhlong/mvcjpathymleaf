package io.codejournal.springprojects.mvcjpathymeleaf;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Transcript;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MvcjpathymeleafApplication {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MvcjpathymeleafApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeStudents() {
		return args -> {
			Transcript transcript = new Transcript();
			transcript.setDegreeTitle("BS Computer Science");

			Student defaultStudent = new Student();
			defaultStudent.setStudentNumber("000-61-0001");
			defaultStudent.setFirstName("Anna");
			defaultStudent.setLastName("Lynn");
			defaultStudent.setMiddleName("Smith");
			defaultStudent.setCgpa(3.45);
			defaultStudent.setDateOfEnrollment("2019/5/24");
			defaultStudent.setPrimaryTranscript(transcript);

			transcript.setStudent(defaultStudent);

			studentRepository.save(defaultStudent);
		};
	}
}