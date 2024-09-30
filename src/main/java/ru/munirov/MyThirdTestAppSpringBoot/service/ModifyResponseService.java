package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.munirov.MyThirdTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
