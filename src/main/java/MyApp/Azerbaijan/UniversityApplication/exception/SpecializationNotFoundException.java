package MyApp.Azerbaijan.UniversityApplication.exception;

public class SpecializationNotFoundException extends NotFoundException {


    public SpecializationNotFoundException(String code, String message, String details) {
        super(code, message, details);
    }
}
