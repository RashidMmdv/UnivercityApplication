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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers = new HashSet<>();
}

