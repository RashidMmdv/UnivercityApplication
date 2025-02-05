package MyApp.Azerbaijan.UniversityApplication.controller;

import MyApp.Azerbaijan.UniversityApplication.model.Specialization;
import MyApp.Azerbaijan.UniversityApplication.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/specialization")
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;

    @PostMapping("/create")
    public Specialization addSpecialization(@RequestBody Specialization specialization) {
        return specializationService.addSpecialization(specialization);
    }
}
