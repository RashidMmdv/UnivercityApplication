package MyApp.Azerbaijan.UniversityApplication.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleStudentNotFound
            (NotFoundException ex, WebRequest request) {
        String language = request.getHeader("Accept-Language");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorResponseDto.builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .code(ex.getCode())
                                .message(ex.getMessage())
                                .detail(ex.getDetails())
                                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                                .requestedLang(language)
                                .build()
                );

    }

    @ExceptionHandler(SpecializationNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleSpecializaiontNotFound
            (NotFoundException ex, WebRequest request) {
        String language = request.getHeader("Accept-Language");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorResponseDto.builder()
                                .status(HttpStatus.NOT_FOUND.value())
                                .code(ex.getCode())
                                .message(ex.getMessage())
                                .detail(ex.getDetails())
                                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                                .requestedLang(language)
                                .build()
                );

    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public final ResponseEntity<ErrorResponseDto> handle(DataIntegrityViolationException ex, WebRequest request) {
        ex.printStackTrace();
        String language = request.getHeader("Accept-Language");

        ErrorResponseDto response = ErrorResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code("DATA_INTEGRITY_VIOLATION")
                .message("Bad request")
                .detail(ex.getMessage())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .requestedLang(language)
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }




    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorResponseDto> handle(HttpMessageNotReadableException ex, WebRequest request) {
        ex.printStackTrace();
        String language = request.getHeader("Accept-Language");

        ErrorResponseDto response = ErrorResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code("HTTP_MESSAGE_NOT_READABLE")
                .message("Bad request")
                .detail(ex.getMessage())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .requestedLang(language)
                .build();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponseDto> handle(MethodArgumentNotValidException ex, WebRequest request) {
        ex.printStackTrace();
        List<ConstraintsViolationError> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ConstraintsViolationError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        String language = request.getHeader("Accept-Language");

        ErrorResponseDto response = ErrorResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .code("ARGUMENT_VALIDATION_FAILED")
                .message("Bad request")
                .detail(ex.getMessage())
                .path(((ServletWebRequest) request).getRequest().getRequestURI())
                .requestedLang(language)
                .build();
        validationErrors.forEach(
                validation -> response.getData()
                        .put(validation.getProperty(), validation.getMessage()));
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }



}
