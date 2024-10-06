package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.munirov.MyThirdTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.munirov.MyThirdTestAppSpringBoot.model.Request;
@Service
public class CheckUidServiceImpl implements CheckUidService{
    @Override
    public void isChecked (Request request) throws UnsupportedCodeException {
        if (request.getUid().equals("123")) {
            throw new UnsupportedCodeException(" Не поддерживаемая ошибка -" +
                    " это сообщение из Сервиса");
        }
    }
}
