package org.eternity.movie.step02;

import org.eternity.money.Money;
import org.eternity.movie.step02.pricing.*;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.*;

class MovieTest {

    @Test
    public void 영화_구현() throws Exception {
        //given
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10),
                    new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10 , 0), LocalTime.of(11, 59)),
                    new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 50))));

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());
    }

    @Test
    public void 영화할인정책_변경() throws Exception {
        //given
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10 , 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 50))));

        //when
        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.5,
                new SequenceCondition(1),
                new SequenceCondition(10)));

        LocalDateTime whenScreened = LocalDateTime.of(2024, 1, 15, 12, 0, 0);
        Screening nowScreening = new Screening(avatar, 1, whenScreened);

        //then
        assertThat(avatar.calculateMovieFee(nowScreening).isEqualTo(Money.wons(5000))).isTrue();
    }

    @Test
    public void 영화할인이_적용되었는지_체크() throws Exception {
        //given
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10 , 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 50))));

        //when
        LocalDateTime whenScreened = LocalDateTime.of(2024, 1, 15, 12, 0, 0);
        Screening nowScreening = new Screening(avatar, 0, whenScreened);

        //then
        assertThat(avatar.calculateMovieFee(nowScreening).isEqualTo(Money.wons(9200))).isFalse();
    }
}