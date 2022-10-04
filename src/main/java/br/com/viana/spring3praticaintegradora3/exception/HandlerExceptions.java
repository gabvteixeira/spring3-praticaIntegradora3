package br.com.viana.spring3praticaintegradora3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(VeiculoNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerVeiculoNotFoundException(VeiculoNotFoundException ex){
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Veiculo não encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}
