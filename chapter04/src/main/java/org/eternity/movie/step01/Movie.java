package org.eternity.movie.step01;

import org.eternity.money.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditionList;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public void setDiscountConditionList(List<DiscountCondition> discountConditionList) {
        this.discountConditionList = discountConditionList;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditionList() {
        return discountConditionList;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }
}
