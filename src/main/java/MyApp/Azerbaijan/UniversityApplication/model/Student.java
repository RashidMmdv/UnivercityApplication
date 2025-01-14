package MyApp.Azerbaijan.UniversityApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String finCode;
    private String name;
    private String surname;
    private byte age;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String entryDate;
}
