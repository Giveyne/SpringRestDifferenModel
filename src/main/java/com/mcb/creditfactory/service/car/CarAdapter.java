package com.mcb.creditfactory.service.car;


import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.model.AssessedValueCar;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {

    private CarDto car;

    @Override
    public BigDecimal getValue() {
        List<AssessedValueCar> values = car.getCarValues();
        return values.stream()
                .max(Comparator.comparing(AssessedValueCar::getAssessedDate))
                .map(AssessedValueCar::getValue)
                .get();
    }


    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

}

