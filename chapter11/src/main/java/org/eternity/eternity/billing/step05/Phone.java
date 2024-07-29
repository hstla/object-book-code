package org.eternity.eternity.billing.step05;

import org.eternity.eternity.money.Money;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    // 합성
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
