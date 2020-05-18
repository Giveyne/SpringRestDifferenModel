package com.mcb.creditfactory.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExternalApprove {

    @Autowired
    private ExternalApproveCarService carService;
    @Autowired
    private ExternalApproveAirplaneService airplaneService;

    public int approve(CollateralObject object) {
        if (object.getDate() == null || object.getYear() == null || object.getValue() == null || object.getType() == null) {
            return -1;
        }

        int code;
        switch (object.getType()) {
            case CAR:
                code = carService.approveCar(object);
                break;
            case AIRPLANE:
                code = airplaneService.approvePlane(object);
                break;
            default:
                code = -100;
        }

        return code;
    }
}
