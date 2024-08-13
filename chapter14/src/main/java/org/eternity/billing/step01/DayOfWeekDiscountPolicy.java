package org.eternity.billing.step01;


public class DayOfWeekDiscountPolicy extends BasicRatePolicy {
    private List<DayOfWeekDiscountRule>  = new ArrayList<>();

    public DayOfWeekDiscountsRule(List<DayOfWeek> dayOfweeks, Duration duration, Money amount) {
        this.dayOfWeeks = dayOfweeks;
        this.duration = duration;
        this.amount = amount;
    }

    public Money calculate(DateTimeInterval interval) {
        if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek())) {
            return amount.times(interval.duration().getSeconds() / duration.getSeconds());
        }
        return Money.ZERO;
    }
}