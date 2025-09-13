package MyApp.Azerbaijan.UniversityApplication.controller;

import MyApp.Azerbaijan.UniversityApplication.dto.StudentCreateDto;
import MyApp.Azerbaijan.UniversityApplication.dto.StudentInfoDto;
import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.service.StudentService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody @Valid StudentCreateDto student) {
        return studentService.createStudent(student);
    }
    @GetMapping("/get-student")
    public Student getStudentWithId(@RequestParam Long id) {
        return studentService.getStudentWithId(id);
    }


    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/get")
    public void getStudents(@ModelAttribute StudentInfoDto student) {
        studentService.getStudent(student);
    }

}
