package com.company.design.parkingLot2.payments;

import java.util.Map;

public class PaymentMechanismResolver {

    Map<String, PaymentMechanisms> tariffStrategyMap;

    PaymentMechanisms getTariffStrategy(String type) {
        return tariffStrategyMap.get(type);
    }
}
