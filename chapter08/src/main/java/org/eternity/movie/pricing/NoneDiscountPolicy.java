package org.eternity.movie.pricing;

import org.eternity.Money.Money;
import org.eternity.movie.DiscountPolicy;
import org.eternity.movie.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
