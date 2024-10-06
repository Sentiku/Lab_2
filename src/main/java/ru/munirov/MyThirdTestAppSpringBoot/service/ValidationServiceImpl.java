package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.munirov.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.munirov.MyThirdTestAppSpringBoot.exception.ValidationFailedException;
import ru.munirov.MyThirdTestAppSpringBoot.model.Response;

import java.util.Objects;

@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if (bindingResult.hasErrors()){
            throw new
                    ValidationFailedException(Objects.requireNonNull(bindingResult.getFieldError()).toString());
        }
    }

//    @Override
//    public void UCException(Response response) throws UnsupportedCodeException {
//        if (response.getUid().equals("123")){
//            throw new UnsupportedCodeException("Неподдерживаемый uid");
//        }
    }
//}
