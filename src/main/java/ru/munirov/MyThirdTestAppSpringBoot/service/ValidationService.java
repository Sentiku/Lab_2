package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.munirov.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.munirov.MyThirdTestAppSpringBoot.exception.ValidationFailedException;
import ru.munirov.MyThirdTestAppSpringBoot.model.Response;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void UCException(Response response) throws UnsupportedCodeException;
}
