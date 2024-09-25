package ru.munirov.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.munirov.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.munirov.MySecondTestAppSpringBoot.exception.ValidationFailedException;
import ru.munirov.MySecondTestAppSpringBoot.model.Response;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void UCException(Response response) throws UnsupportedCodeException;
}
