package ru.munirov.MyThirdTestAppSpringBoot.model;

import lombok.Builder;
import lombok.Data;
import ru.munirov.MyThirdTestAppSpringBoot.exception.Codes;
import ru.munirov.MyThirdTestAppSpringBoot.exception.ErrorCodes;
import ru.munirov.MyThirdTestAppSpringBoot.exception.ErrorMessages;

@Builder
@Data
public class Response {

    private String uid;
    private String operationUid;
    private String systemTime;
    private Codes code;
    private Double annualBonus;
    private ErrorCodes errorCode;
    private ErrorMessages errorMessage;
    private Double quarterlyBonus;
}
