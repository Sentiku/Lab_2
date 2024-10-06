package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.munirov.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.munirov.MyThirdTestAppSpringBoot.model.Request;
@Service
public interface CheckUidService {
    void isChecked (Request request) throws UnsupportedCodeException;

}
