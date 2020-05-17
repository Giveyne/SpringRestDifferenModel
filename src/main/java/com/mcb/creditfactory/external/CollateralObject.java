package com.mcb.creditfactory.external;

import com.mcb.creditfactory.dto.Collateral;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CollateralObject {

    BigDecimal getValue();
    Short getYear();
    LocalDate getDate();
    CollateralType getType();

}
