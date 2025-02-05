package MyApp.Azerbaijan.UniversityApplication.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    String code;
    String message;
    String details;

    public NotFoundException(String code,String message, String details) {
        super(details);
        this.code = code;
        this.message = message;
        this.details = details;
    }
}
