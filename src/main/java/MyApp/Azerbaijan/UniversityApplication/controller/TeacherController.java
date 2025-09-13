package MyApp.Azerbaijan.UniversityApplication.controller;

import MyApp.Azerbaijan.UniversityApplication.dto.TeacherCreateDto;
import MyApp.Azerbaijan.UniversityApplication.model.Subject;
import MyApp.Azerbaijan.UniversityApplication.model.Teacher;
import MyApp.Azerbaijan.UniversityApplication.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
@Validated
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/create")
    public Teacher createTeacher(@Valid @RequestBody TeacherCreateDto teacher) {
        return teacherService.createTeacher(teacher);
    }
    @GetMapping("/get")
    public Teacher getTeacher(@RequestParam Long teacherId) {
        return teacherService.getTeacher(teacherId);
    }
    @PostMapping("add-subject")
    public Teacher TeacherAddSubject(@RequestParam Long teacherId,
                                     @RequestParam Long subjectId) {
        return teacherService.TeacherAddSubject(teacherId,subjectId);
    }
}
