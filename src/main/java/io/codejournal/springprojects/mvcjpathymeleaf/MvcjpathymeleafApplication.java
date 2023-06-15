package io.codejournal.springprojects.mvcjpathymeleaf;

import io.codejournal.springprojects.mvcjpathymeleaf.entity.Course;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Student;
import io.codejournal.springprojects.mvcjpathymeleaf.entity.Transcript;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.CourseRepository;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.StudentRepository;
import io.codejournal.springprojects.mvcjpathymeleaf.repository.TranscriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class MvcjpathymeleafApplication {

	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final TranscriptRepository transcriptRepository;

	public MvcjpathymeleafApplication(StudentRepository studentRepository, CourseRepository courseRepository, TranscriptRepository transcriptRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.transcriptRepository = transcriptRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcjpathymeleafApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializeStudents() {
		return args -> {
			// Create and save courses
			Course course1 = new Course();
			course1.setCourseCode("C001");
			course1.setCourseName("Introduction to Programming");
			course1 = courseRepository.save(course1);

			Course course2 = new Course();
			course2.setCourseCode("C002");
			course2.setCourseName("Database Management");
			course2 = courseRepository.save(course2);

			// Create and save students
			Student student1 = new Student();
			student1.setStudentNumber("000-61-0001");
			student1.setFirstName("Anna");
			student1.setLastName("Lynn");
			student1.setMiddleName("Smith");
			student1.setCgpa(3.45);
			student1.setDateOfEnrollment("2019/5/24");
			student1.getCourses().add(course1);
			student1.getCourses().add(course2);
			studentRepository.save(student1);

			Student student2 = new Student();
			student2.setStudentNumber("000-61-0002");
			student2.setFirstName("Tom");
			student2.setLastName("Bruce");
			student2.setMiddleName("");
			student2.setCgpa(3.9);
			student2.setDateOfEnrollment("2020/6/20");
			student2.getCourses().add(course1);
			student2.getCourses().add(course2);
			studentRepository.save(student2);

			// Create and save transcript
			Transcript transcript = new Transcript();
			transcript.setDegreeTitle("BS Computer Science");
			transcript.setStudent(student1);
			transcriptRepository.save(transcript);
		};
	}
}
