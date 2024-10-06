package ru.munirov.MyThirdTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import ru.munirov.MyThirdTestAppSpringBoot.exception.Position;

@Service
public interface QuarterlyBonusService {
    double calculateQuarterlyBonus(Position position, double salary, double bonus, int workDays);

}
