package org.eternity.eternity.billing.step02;

import org.eternity.eternity.money.Money;

import java.time.Duration;

public class TaxableRegularPhone extends RegularPhone{
    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee();
        return fee.plus(fee.times(taxRate));
    }
}