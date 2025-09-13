package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.dto.TeacherCreateDto;
import MyApp.Azerbaijan.UniversityApplication.exception.NotFoundException;
import MyApp.Azerbaijan.UniversityApplication.model.Subject;
import MyApp.Azerbaijan.UniversityApplication.model.Teacher;
import MyApp.Azerbaijan.UniversityApplication.repository.SubjectRepository;
import MyApp.Azerbaijan.UniversityApplication.repository.TeacherRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    private final ModelMapper mapper;

    public Teacher createTeacher(TeacherCreateDto teacher) {
        return teacherRepository.save(mapper.map(teacher, Teacher.class));
    }

    public Teacher getTeacher(Long teacherId) {
        return teacherRepository.findById(teacherId).
                orElseThrow(()-> new NotFoundException("TEACHER_NOT_FOUND","Teacher not found",
                        "Teacher with id " + teacherId + " not found"));
    }

    public Teacher TeacherAddSubject(Long teacherId, Long subjectId) {

        Teacher teacher = teacherRepository.findById(teacherId).get();
        Subject subject = subjectRepository.findById(subjectId).get();
        subject.getTeachers().add(teacher);
        return teacherRepository.save(teacher);
    }
}
