package org.eternity.movie.step02.pricing;

import org.eternity.money.Money;
import org.eternity.movie.step02.DefaultDiscountPolicy;
import org.eternity.movie.step02.Screening;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
