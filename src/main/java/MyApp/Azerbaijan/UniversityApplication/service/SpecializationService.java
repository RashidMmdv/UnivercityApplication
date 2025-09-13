package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.exception.NotFoundException;
import MyApp.Azerbaijan.UniversityApplication.exception.SpecializationNotFoundException;
import MyApp.Azerbaijan.UniversityApplication.model.Group;
import MyApp.Azerbaijan.UniversityApplication.model.Specialization;
import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.repository.GroupRepository;
import MyApp.Azerbaijan.UniversityApplication.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SpecializationService {

    private final SpecializationRepository specializationRepository;
    private final GroupRepository groupRepository;

    public Specialization addSpecialization(Specialization specialization) {
        Specialization special = Specialization.builder()
                .name(specialization.getName())
                .build();
        return specializationRepository.save(special);
    }

    public Specialization addGroupToSpecialization(Long specialId, Long groupId) {
        Specialization specialization = specializationRepository.findById(specialId).get();
        Group group = groupRepository.findById(groupId).get();
        specialization.getGroups().add(group);
        return specializationRepository.save(specialization);
    }

    public Specialization getSpecialization(String name) {
        Specialization specializationName = specializationRepository.findByName(name);
        if (specializationName == null) {
             throw  new SpecializationNotFoundException("SPECIALIZETiON_NOT_FOUND",
                    "Specialization not found",
                    "Specialization with id " + name + " not found");
        }
        return specializationName;
    }
}
