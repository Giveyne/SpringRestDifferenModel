package com.mcb.creditfactory.service.car;


import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {

    private CarDto car;

    @Override
    public BigDecimal getValue() {
        List<AssessedValue> values = (List)car.getValues();
        return values.stream().max(Comparator.comparing(AssessedValue::getDate)).get().getValue();
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

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}

