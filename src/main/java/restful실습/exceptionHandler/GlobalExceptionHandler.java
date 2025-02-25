package restful실습.exceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    //runtime예외가 발생했을때 넣음
    //예외 발생할때마다 서비스에서 예외 메세지를 발생시켰는데, 그걸 출력시켜주는 역할을 한다.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String>  handlerRuntimeException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error : "+e.getMessage());
    }
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> hand(ResponseStatusException e){
        return ResponseEntity.status(e.getStatusCode())
                .body("Custom Error : " + e.getMessage() );
    }
}
