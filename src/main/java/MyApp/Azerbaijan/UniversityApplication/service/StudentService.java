package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.dto.StudentCreateDto;
import MyApp.Azerbaijan.UniversityApplication.exception.StudentNotFoundException;
import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.repository.StudentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper mapper;


    public Student createStudent( StudentCreateDto student) {
        return studentRepository.save(mapper.map(student, Student.class));
    }

    public Student getStudentWithId(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("STUDENT_NOT_FOUND_0001","Student not found","Student with id " + id + " not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }
}
