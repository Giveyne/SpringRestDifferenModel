package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: reimplement this
@Service
public class RestCollateralService {

    private Map<Class, CollateralService> collateralServices;

    @Autowired
    public RestCollateralService(List<CollateralService> collateralServices) {
        this.collateralServices = collateralServices.stream().collect(Collectors. toMap(CollateralService::getDtoClass, s -> s));
    }

    @SuppressWarnings("ConstantConditions")
    public <U, T extends Collateral> Long saveCollateral(T object) {
        CollateralService<U, T> service = collateralServices.get(object.getClass());

        if (service == null) {
            throw new IllegalArgumentException();
        }
        boolean approved = service.approve(object);
        if (!approved) {
            return null;
        }

        return Optional.of(object)
                .map(service::fromDto)
                .map(service::save)
                .map(service::getId)
                .orElse(null);
    }

    public <U, T extends Collateral> T getInfo(T object) {
        CollateralService<U, T> service = collateralServices.get(object.getClass());
        return Optional.of(object)
                .map(service::fromDto)
                .map(service::getId)
                .flatMap(service::load)
                .map(service::toDTO)
                .orElse(null);
    }
}
