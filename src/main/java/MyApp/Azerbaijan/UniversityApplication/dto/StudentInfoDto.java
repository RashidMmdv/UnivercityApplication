package MyApp.Azerbaijan.UniversityApplication.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class StudentInfoDto {
    private String name;
    private String surname;
    private byte age;
}
