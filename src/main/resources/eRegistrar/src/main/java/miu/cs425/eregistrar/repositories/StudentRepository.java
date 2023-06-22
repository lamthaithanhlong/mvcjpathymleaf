package miu.cs425.eregistrar.repositories;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import miu.cs425.eregistrar.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findStudentByStudentIdOrFirstNameOrMiddleNameOrLastName(Integer studentId,
                                                                          @NotNull @NotEmpty String firstName,
                                                                          String middleName,
                                                                          @NotNull @NotEmpty String lastName);
}
