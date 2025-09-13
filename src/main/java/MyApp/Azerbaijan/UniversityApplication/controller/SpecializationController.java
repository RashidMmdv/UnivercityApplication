package MyApp.Azerbaijan.UniversityApplication.controller;

import MyApp.Azerbaijan.UniversityApplication.model.Group;
import MyApp.Azerbaijan.UniversityApplication.model.Specialization;
import MyApp.Azerbaijan.UniversityApplication.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specialization")
@RequiredArgsConstructor
public class SpecializationController {

    private final SpecializationService specializationService;

    @PostMapping("/create")
    public Specialization addSpecialization(@RequestBody Specialization specialization) {
        return specializationService.addSpecialization(specialization);
    }
    @PostMapping("/add-group")
    public Specialization addGroupToSpecialization(@RequestParam Long specialId,
                                   @RequestParam Long groupId) {
        return specializationService.addGroupToSpecialization(specialId, groupId);
    }
    @GetMapping
    public Specialization getSpecialization(@RequestParam String name) {
        return specializationService.getSpecialization(name);
    }
}
