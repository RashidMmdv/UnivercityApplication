package MyApp.Azerbaijan.UniversityApplication.controller;

import MyApp.Azerbaijan.UniversityApplication.model.Subject;
import MyApp.Azerbaijan.UniversityApplication.repository.SubjectRepository;
import MyApp.Azerbaijan.UniversityApplication.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/create")
    public Subject creayeSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }
}
