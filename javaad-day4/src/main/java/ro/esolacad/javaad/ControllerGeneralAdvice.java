package ro.esolacad.javaad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerGeneralAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> returnErrorMssage(RuntimeException re) {
        re.printStackTrace();

        return ResponseEntity.status(HttpStatus.OK)
                .body("Sorry! We are having some problems :)");
    }
}
