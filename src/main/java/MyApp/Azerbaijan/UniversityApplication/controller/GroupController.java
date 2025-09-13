package MyApp.Azerbaijan.UniversityApplication.controller;


import MyApp.Azerbaijan.UniversityApplication.model.Group;
import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.repository.GroupRepository;
import MyApp.Azerbaijan.UniversityApplication.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }
    @PostMapping("/add-student")
    public Group addStudentToGroup(@RequestParam Long studentId,
                                   @RequestParam Long groupId) {
        return groupService.addStudentToGroup(studentId, groupId);
    }
    @DeleteMapping("/delete-student")
    public Group deleteStudent(@RequestParam Long studentId,
                              @RequestParam Long groupId) {
        return groupService.deleteStudent(studentId,groupId);
    }
    @GetMapping("/get-student")
    public Student getStudent(@RequestParam Long studentId,
                              @RequestParam Long groupId) {
        return groupService.getStudent(studentId,groupId);
    }
    @GetMapping("/get-student-fin")
    public Student getStudentWithFinCode(@RequestParam String finCode,
                                         @RequestParam Long groupId) {
        return groupService.getStudentWithFinCode(finCode,groupId);
    }
}
