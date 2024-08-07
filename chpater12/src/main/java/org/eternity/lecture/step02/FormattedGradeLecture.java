package org.eternity.lecture.step02;

import org.eternity.lecture.step02.Grade;
import org.eternity.lecture.step02.GradeLecture;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {
    public FormattedGradeLecture(String name, int pass, List<Grade> grades, List<Integer> scores) {
        super(name, pass, grades, scores);
    };

    public String formatAverage() {
        return String.format("Avg: %1.1f", super.average());
    }
}