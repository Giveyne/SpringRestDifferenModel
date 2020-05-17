package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import org.springframework.beans.factory.annotation.Autowired;

public interface CollateralService {

    Long saveCollateral(Collateral collateral);

    Collateral getInfo(Collateral collateral);
}
