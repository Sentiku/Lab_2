package ru.munirov.MyThirdTestAppSpringBoot.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.munirov.MyThirdTestAppSpringBoot.exception.*;
import ru.munirov.MyThirdTestAppSpringBoot.model.Request;
import ru.munirov.MyThirdTestAppSpringBoot.model.Response;
import ru.munirov.MyThirdTestAppSpringBoot.service.*;
import ru.munirov.MyThirdTestAppSpringBoot.util.DateTimeUtil;

import java.text.ParseException;
import java.util.Date;

@Slf4j
@RestController
public class MyController {
    private final ValidationService validationService;
    private final ModifyResponseService modifyResponseService;
    private final CheckUidService checkUidService;
    @Autowired
    public MyController(CheckUidService checkUidService, ValidationService validationService, @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationService = validationService;
        this.modifyResponseService = modifyResponseService;
        this.checkUidService = checkUidService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity <Response> feedback(@Valid @RequestBody Request request, BindingResult bindingResult) throws ParseException {

        log.info("request: {}", request);
        Response response = ResponseBuilderService.buildResponse(request);
        log.info("System time success set: {}", response.getSystemTime());
        try{
            validationService.isValid(bindingResult);
            checkUidService.isChecked(request);
        } catch (ValidationFailedException e){
            return ErrorCatcherService.handleValidationException(response, e);
        } catch (Exception e){
            return ErrorCatcherService.handleUnknownException(response, e);
        } catch (UnsupportedCodeException e){
            return ErrorCatcherService.handleUnsupportedCodeException(response, e);
        }
        if (response.getUid().length() < 33 & response.getOperationUid().length() < 33 & 1 < request.getCommunicationId() & request.getCommunicationId() < 100000){
            log.info("Code status: {}", Codes.SUCCESS);
            log.info("Response: {}", response);
            modifyResponseService.modify(response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.OUT_OF_RANGE);
            response.setErrorMessage(ErrorMessages.RANGE);
            log.error("Code status: {}", Codes.FAILED);
            log.error("Error code: {}", ErrorCodes.OUT_OF_RANGE);
            log.error("Error message: {}", ErrorMessages.RANGE);
            log.info("Response: {}", response);
            modifyResponseService.modify(response);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
