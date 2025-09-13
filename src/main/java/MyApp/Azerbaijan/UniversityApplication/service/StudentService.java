package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.dto.StudentCreateDto;
import MyApp.Azerbaijan.UniversityApplication.dto.StudentInfoDto;
import MyApp.Azerbaijan.UniversityApplication.exception.StudentNotFoundException;
import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;


    public Student createStudent(StudentCreateDto student) {
        return studentRepository.save(mapper.map(student, Student.class));
    }

    public Student getStudentWithId(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("STUDENT_NOT_FOUND_0001", "Student not found", "Student with id " + id + " not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }


    public void getStudent(StudentInfoDto student) {
        log.info("Get student " + student.getName());
        if (student.getName().equals("Rashid")) {
            student.setName("RASHID");
        }else {
            student.setName("SAID");
        }
        log.info("Get student " + student);
    }
}