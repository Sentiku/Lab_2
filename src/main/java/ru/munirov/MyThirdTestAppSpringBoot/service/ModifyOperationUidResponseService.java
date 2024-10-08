package ru.munirov.MyThirdTestAppSpringBoot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.munirov.MyThirdTestAppSpringBoot.model.Response;

import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponseService")
@Slf4j
public class ModifyOperationUidResponseService implements ModifyResponseService{
    @Override
    public Response modify(Response response) {
        UUID uuid = UUID.randomUUID();

        response.setOperationUid(uuid.toString());
        log.info("Operation uid is successful set {}", response.getOperationUid());
        return response;
    }
}
