package org.eternity;

import org.eternity.lecture.step02.FormattedGradeLecture;
import org.eternity.lecture.step02.Grade;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! 12");

        FormattedGradeLecture formattedGradeLecture = new FormattedGradeLecture("test", 70,
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70)
                ),
                Arrays.asList(95, 85, 75));
        // super: 지금 이 클래스의 부모 클래스에서부터 메서드 탐색을 시작하세요.
        System.out.println(formattedGradeLecture.evaluate());
    }
}