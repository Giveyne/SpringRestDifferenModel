package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValueAirplane;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {

    private AirplaneDto airplane;

    @Override
    public BigDecimal getValue() {
        List <AssessedValueAirplane> values = airplane.getAirplaneValues();
        return  values.stream()
                .max(Comparator.comparing(AssessedValueAirplane::getAssessedDate))
                .map(AssessedValueAirplane::getValue)
                .get();
    }


    @Override
    public Short getYear() {
        return airplane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return airplane.getAirplaneValues().stream()
                .max(Comparator.comparing(AssessedValueAirplane::getAssessedDate))
                .map(AssessedValueAirplane::getAssessedDate)
                .get();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
