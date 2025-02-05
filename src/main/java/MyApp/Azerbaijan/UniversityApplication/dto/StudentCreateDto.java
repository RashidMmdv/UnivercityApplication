package MyApp.Azerbaijan.UniversityApplication.dto;
import MyApp.Azerbaijan.UniversityApplication.model.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentCreateDto {
    @NotBlank
    @Column(unique = true)
    @Size(min = 7, max = 7)
    private String finCode;
    @NotBlank
    @Size(min = 3, max = 50, message = "Name length must be between 3 and 50")
    private String name;
    @NotNull
    private String surname;
    @Min(18)
    @Max(100)
    @NotNull
    private byte age;
    @NotNull
    private Gender gender;
    private String phone;
    @NotBlank
    private String email;
    private String address;
    private String entryDate;
}
