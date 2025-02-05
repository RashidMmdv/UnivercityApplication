package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.model.Specialization;
import MyApp.Azerbaijan.UniversityApplication.repository.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    public Specialization addSpecialization(Specialization specialization) {
        Specialization special = Specialization.builder()
                .name(specialization.getName())
                .build();
        return specializationRepository.save(special);
    }
}
