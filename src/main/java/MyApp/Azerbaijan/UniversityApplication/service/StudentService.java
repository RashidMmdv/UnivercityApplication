package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student createStudent(Student student) {
        Student newStudent = Student.builder()
                .name(student.getName())
                .surname(student.getSurname())
                .age(student.getAge())
                .gender(student.getGender())
                .finCode(student.getFinCode())
                .phone(student.getPhone())
                .email(student.getEmail())
                .address(student.getAddress())
                .entryDate(student.getEntryDate())
                .build();
        return studentRepository.save(newStudent);
    }

    public Student getStudentWithId(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new
                RuntimeException("Student with id " + id + " not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }
}
