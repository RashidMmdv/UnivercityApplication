package MyApp.Azerbaijan.UniversityApplication.repository;

import MyApp.Azerbaijan.UniversityApplication.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
