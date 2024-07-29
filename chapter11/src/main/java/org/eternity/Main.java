package org.eternity;

import org.eternity.eternity.billing.step03.RegularPhone;
import org.eternity.eternity.billing.step05.*;
import org.eternity.eternity.money.Money;

import java.math.BigDecimal;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! 11");
        RegularPhone phone = new RegularPhone(new Money(new BigDecimal(123)),  Duration.ofSeconds(1000));
        Phone phone5 = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        Phone phone5n = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));

        new Phone(new TaxablePolicy(0.05, new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))));
        new Phone(new RateDiscountablePolicy(Money.wons(1000),
                new TaxablePolicy(0.05,
                        new RegularPolicy(Money.wons(1000), Duration.ofSeconds(10)))));
    }
}