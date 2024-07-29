package org.eternity.eternity.billing.step05;

import org.eternity.eternity.money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
