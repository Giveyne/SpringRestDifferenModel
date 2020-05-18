package com.mcb.creditfactory.external;

public interface ExternalApproveService<T extends CollateralObject> {
    int approve(T object);
}
