package MyApp.Azerbaijan.UniversityApplication.repository;

import MyApp.Azerbaijan.UniversityApplication.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
