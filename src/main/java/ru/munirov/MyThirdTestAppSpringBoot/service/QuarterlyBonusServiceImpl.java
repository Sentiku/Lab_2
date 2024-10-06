package ru.munirov.MyThirdTestAppSpringBoot.service;

import ru.munirov.MyThirdTestAppSpringBoot.exception.Position;

import java.time.Year;

public class QuarterlyBonusServiceImpl implements QuarterlyBonusService{
    @Override
    public double calculateQuarterlyBonus(Position position, double salary, double bonus, int workDays) {

        int year = Year.now().getValue();
        int daysInYear = Year.isLeap(year) ? 366 : 365;
        return salary * bonus * daysInYear * position.getPositionCoefficient() / workDays / 4;
    }
}
