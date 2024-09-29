package ru.munirov.MySecondTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.munirov.MySecondTestAppSpringBoot.exception.Codes;
import ru.munirov.MySecondTestAppSpringBoot.exception.ErrorCodes;
import ru.munirov.MySecondTestAppSpringBoot.exception.ErrorMessages;

@Builder
@Data
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
}
