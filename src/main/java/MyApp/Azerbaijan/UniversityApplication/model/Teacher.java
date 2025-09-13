package MyApp.Azerbaijan.UniversityApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private byte age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String finCode;
    private String department;
    private String position;
    private String academicDegree;

    @ManyToMany
    @JoinTable(
            name = "teacher_subject",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();

//    @ManyToMany(mappedBy = "scores")
//    private Set<Score> scores = new HashSet<>();

}
