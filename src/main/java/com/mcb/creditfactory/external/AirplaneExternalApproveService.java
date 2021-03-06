package com.mcb.creditfactory.external;

import com.mcb.creditfactory.service.airplane.AirplaneAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
@Slf4j
public class AirplaneExternalApproveService implements ExternalApproveService<AirplaneAdapter> {

    private static final LocalDate MIN_ASSESS_DATE = LocalDate.of(2017, Month.OCTOBER, 1);
    private static final int MIN_PLANE_YEAR = 1991;
    private static final BigDecimal MIN_PLANE_VALUE = BigDecimal.valueOf(230000000);

    @Override
    public int approve(AirplaneAdapter object) {
        if (object.getYear() < MIN_PLANE_YEAR) {
            return -20;
        }
        if (object.getDate().isBefore(MIN_ASSESS_DATE)) {
            return -21;
        }
        if (object.getValue().compareTo(MIN_PLANE_VALUE) < 0) {
            return -22;
        }

        return 0;
    }
}
