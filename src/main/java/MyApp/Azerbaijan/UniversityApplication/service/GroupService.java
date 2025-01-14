package MyApp.Azerbaijan.UniversityApplication.service;

import MyApp.Azerbaijan.UniversityApplication.model.Group;
import MyApp.Azerbaijan.UniversityApplication.model.Student;
import MyApp.Azerbaijan.UniversityApplication.repository.GroupRepository;
import MyApp.Azerbaijan.UniversityApplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;


    public Group createGroup(Group group) {
        Group newGroup = Group
                .builder()
                .groupName(group.getGroupName())
                .build();
        return groupRepository.save(newGroup);
    }

    public Group addStudentToGroup(Long studentId, Long groupId) {
        Student student = studentRepository.findById(studentId).get();
        Group group = groupRepository.findById(groupId).get();
        group.getStudents().add(student);
        return groupRepository.save(group);
    }

    public Group deleteStudent(Long studentId, Long groupId) {
        Group group = groupRepository.findById(groupId).get();
        Student student = studentRepository.findById(studentId).get();
        group.getStudents().remove(student);
        studentRepository.delete(student);
        return groupRepository.save(group);
    }
}
