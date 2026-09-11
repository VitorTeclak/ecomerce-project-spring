package vitorteclak.ecomerce.exceptions.hander;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vitorteclak.ecomerce.exceptions.NotFound;
import vitorteclak.ecomerce.exceptions.TokenExpired;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NotFound ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        body.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(TokenExpired.class)
    public ResponseEntity<Map<String, Object>> handleTokenExpired(TokenExpired tx){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", HttpStatus.FORBIDDEN.value());
        body.put("error", HttpStatus.FORBIDDEN.getReasonPhrase());
        body.put("message", tx.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
    }
}
