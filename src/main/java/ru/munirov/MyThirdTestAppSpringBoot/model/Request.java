package ru.munirov.MyThirdTestAppSpringBoot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.munirov.MyThirdTestAppSpringBoot.exception.Position;
import ru.munirov.MyThirdTestAppSpringBoot.exception.System;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "UID не может быть пустым")
    private String uid;
    @NotBlank(message = "поле operationUid не может быть пустым")
    private String operationUid;
    private System systemName;
    private String systemTime;
    private String source;
    private Position position;
    private Double salary;
    private Double bonus;
    private Integer workDays;
    private Integer communicationId;
    private Integer templateId;
    private Integer productCode;
    private Integer smsCode;
    @Override
    public String toString(){
        return "{" +
                "uid='" + uid +'\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", position='" + position + '\'' +
                ", salary='" + salary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", workDays='" + workDays + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateID='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';
    }
}
