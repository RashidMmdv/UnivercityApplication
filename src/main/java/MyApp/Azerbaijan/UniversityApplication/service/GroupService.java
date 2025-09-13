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

    public Student getStudent(Long studentId, Long groupId) {
        Group group = groupRepository.findGroupByIdAndStudentId(groupId, studentId)
                .orElseThrow(() -> new IllegalArgumentException("Group with ID " + groupId +
                                        " does not contain Student with ID " + studentId));
        return group.getStudents().stream()
                .filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student with ID " + studentId + " not found in Group ID " + groupId));

    }

    public Student getStudentWithFinCode(String finCode, Long groupId) {
        Group group = groupRepository.findGroupByIdAndStudentFinCode(groupId,finCode)
                .orElseThrow(() -> new IllegalArgumentException("Group with ID " + groupId +
                                        " does not contain Student with FinCode" +finCode));
        return group.getStudents().stream()
                .filter(student -> student.getFinCode().equals(finCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student with ID " + finCode +
                        " not found in Group ID " + groupId));

    }
}
