package com.example.test.handlers;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();


        //body.put("status", status.value());
        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());



//        errors.forEach(x->{
//            if (x.toString().equals("El email debe ser valido")){
//                body.put("data", "La informacion no tiene la estructura correcta para procesar la solicitud");
//                body.put("messageCode","ERR_004");
//                body.put("messageComercial", "La información enviada no es compatible");
//            }
//            else {
//                body.put("data", "La informacion no es suficiente  para procesar la solicitud");
//                body.put("messageCode","ERR_003");
//                body.put("messageComercial", "Información incompleta");
//            }
//        });
        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }

}
