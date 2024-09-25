package ru.munirov.MySecondTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.munirov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.munirov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.munirov.MySecondTestAppSpringBoot.model.Request;
import ru.munirov.MySecondTestAppSpringBoot.model.Response;
import ru.munirov.MySecondTestAppSpringBoot.service.ValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
public class MyController {
    private final ValidationService validationService;

    @PostMapping(value = "/feedback")
    public ResponseEntity <Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        try{
            validationService.isValid(bindingResult);
            validationService.UCException(response);
        } catch (ValidationFailedException e){
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            response.setCode("failed");
            response.setErrorCode("UnknownError");
            response.setErrorMessage("Произошла непредвиденная ошибка");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (UnsupportedCodeException e){
            response.setCode("failed");
            response.setErrorCode("UnsupportedCodeException");
            response.setErrorMessage("Неподдерживаемый uid");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (response.getUid().length() < 33 & response.getOperationUid().length() < 33 & 1 < request.getCommunicationId() & request.getCommunicationId() < 100000){
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setCode("failed");
            response.setErrorCode("OutOfRange");
            response.setErrorMessage("Параметры вне диапазона");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
