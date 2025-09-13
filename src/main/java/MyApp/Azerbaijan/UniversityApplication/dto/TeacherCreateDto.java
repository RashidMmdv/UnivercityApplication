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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeacherCreateDto {
    @NotBlank
    @Size(min = 3, max = 50, message = "Name length must be between 3 and 50")
    private String name;
    @NotNull
    private String surName;
    @NotBlank
    private String email;
    private String phone;
    @Min(22)
    @Max(100)
    @NotNull
    private byte age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotBlank
    @Column(unique = true)
    @Size(min = 7, max = 7)
    private String finCode;
    @NotBlank
    private String department;
    @NotBlank
    private String position;
    @NotBlank
    private String academicDegree;
}
