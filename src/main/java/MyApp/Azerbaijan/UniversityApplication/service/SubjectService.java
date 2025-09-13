package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.model.Subject;
import MyApp.Azerbaijan.UniversityApplication.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ModelMapper modelMapper;

    public Subject createSubject(Subject subject) {
        return modelMapper.map(subjectRepository.save(subject), Subject.class);
    }
}
