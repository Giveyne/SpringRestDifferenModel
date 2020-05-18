package com.mcb.creditfactory.external;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
public class ExternalApproveCarService {
    private static final LocalDate MIN_ASSESS_DATE = LocalDate.of(2017, Month.OCTOBER, 1);
    private static final int MIN_CAR_YEAR = 2000;
    private static final BigDecimal MIN_CAR_VALUE = BigDecimal.valueOf(1000000);


    protected int approveCar(CollateralObject object) {
        if (object.getYear() < MIN_CAR_YEAR) {
            return -10;
        }
        if (object.getDate().isBefore(MIN_ASSESS_DATE)) {
            return -11;
        }
        if (object.getValue().compareTo(MIN_CAR_VALUE) < 0) {
            return -12;
        }

        return 0;
    }

}
