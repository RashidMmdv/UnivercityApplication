package MyApp.Azerbaijan.UniversityApplication.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "faculty_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String groupName;
    private String facultyName;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Student> students = new HashSet<>();

}
