package MyApp.Azerbaijan.UniversityApplication.exception;

public class StudentNotFoundException extends NotFoundException {


    public StudentNotFoundException(String code, String message, String details) {
        super(code, message, details);
    }
}
