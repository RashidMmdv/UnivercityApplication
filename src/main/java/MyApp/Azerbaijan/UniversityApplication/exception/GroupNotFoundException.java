package MyApp.Azerbaijan.UniversityApplication.exception;

public class GroupNotFoundException extends NotFoundException {


    public GroupNotFoundException(String code, String message, String details) {
        super(code, message, details);
    }
}
