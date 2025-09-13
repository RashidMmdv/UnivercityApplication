package MyApp.Azerbaijan.UniversityApplication.repository;

import MyApp.Azerbaijan.UniversityApplication.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
