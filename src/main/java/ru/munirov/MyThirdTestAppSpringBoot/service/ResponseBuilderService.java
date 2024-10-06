package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.munirov.MyThirdTestAppSpringBoot.exception.Codes;
import ru.munirov.MyThirdTestAppSpringBoot.exception.ErrorCodes;
import ru.munirov.MyThirdTestAppSpringBoot.exception.ErrorMessages;
import ru.munirov.MyThirdTestAppSpringBoot.model.Request;
import ru.munirov.MyThirdTestAppSpringBoot.model.Response;
import ru.munirov.MyThirdTestAppSpringBoot.util.DateTimeUtil;

import java.text.ParseException;
import java.util.Date;

@Service
public class ResponseBuilderService {
    public static Response buildResponse(Request request) throws ParseException {
        Response.ResponseBuilder builder = Response.builder();
        if (request.getPosition().isManager()) {
            builder.uid(request.getUid());
            builder.operationUid(request.getOperationUid());
            builder.systemTime(DateTimeUtil.getCustomFormat().format(new Date()));
            builder.code(Codes.SUCCESS);
            builder.annualBonus(new AnnualBonusServiceImpl().calculate
                    (request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()));
            builder.quarterlyBonus(new QuarterlyBonusServiceImpl().calculateQuarterlyBonus
                    (request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()));
            builder.errorCode(ErrorCodes.EMPTY);
            builder.errorMessage(ErrorMessages.EMPTY);
            return   builder.build();
        } else {
            builder.uid(request.getUid());
            builder.operationUid(request.getOperationUid());
            builder.systemTime(DateTimeUtil.getCustomFormat().format(new Date()));
            builder.code(Codes.SUCCESS);
            builder.annualBonus(new AnnualBonusServiceImpl().calculate
                    (request.getPosition(), request.getSalary(), request.getBonus(), request.getWorkDays()));
            builder.quarterlyBonus(0.0);
            builder.errorCode(ErrorCodes.EMPTY);
            builder.errorMessage(ErrorMessages.EMPTY);
            return builder.build();
        }
    }
}
