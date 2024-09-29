package ru.munirov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.munirov.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
