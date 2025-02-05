package MyApp.Azerbaijan.UniversityApplication.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true )
    private String finCode;
    private String name;
    private String surname;
    private byte age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phone;
    private String email;
    private String address;
    private String entryDate;


}
