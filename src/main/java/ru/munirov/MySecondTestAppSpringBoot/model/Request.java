package ru.munirov.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank
    @NotNull
    private String uid;
    @NotNull
    private String operationUid;
    private String systemName;
    @NotNull
    private String systemTime;
    @NotNull
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;
}
