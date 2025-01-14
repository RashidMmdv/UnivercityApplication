package MyApp.Azerbaijan.UniversityApplication.controller;

import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.service.StudentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    @GetMapping("/get-student")
    public Student getStudentWithId(@RequestParam Long id) {
        return studentService.getStudentWithId(id);
    }
}
