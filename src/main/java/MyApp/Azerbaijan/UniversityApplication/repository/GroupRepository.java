package MyApp.Azerbaijan.UniversityApplication.repository;

import MyApp.Azerbaijan.UniversityApplication.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long>{

    @Query("SELECT g FROM Group g JOIN FETCH g.students s WHERE g.id = :groupId AND s.id = :studentId")
    Optional<Group> findGroupByIdAndStudentId(@Param("groupId") Long groupId,
                                              @Param("studentId") Long studentId);

    @Query("SELECT g FROM Group g JOIN FETCH g.students s WHERE g.id = :groupId AND s.finCode = :finCode")
    Optional<Group> findGroupByIdAndStudentFinCode(@Param("groupId") Long groupId,
                                              @Param("finCode") String finCode);

}

