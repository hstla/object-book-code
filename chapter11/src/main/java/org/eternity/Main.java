package org.eternity;

import org.eternity.eternity.billing.step03.RegularPhone;
import org.eternity.eternity.money.Money;

import java.math.BigDecimal;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! 11");
        RegularPhone phone = new RegularPhone(new Money(new BigDecimal(123)),  Duration.ofSeconds(1000));
//      protected라서 사용불가.
//        phone.afterCalculated(new Money(new BigDecimal(123)));
    }
}