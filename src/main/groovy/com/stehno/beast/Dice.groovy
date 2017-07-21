package com.stehno.beast

import groovy.transform.Immutable

import java.security.SecureRandom
import java.util.regex.Matcher
import java.util.regex.Pattern

@Immutable
class Dice {

    private static final Pattern pattern = Pattern.compile('([1-9]*)d([1-9]?[0-9]?[0-9])[+]?([1-9]?)')
    private static final Random rng = new SecureRandom()

    int rolls
    int die
    int modifier

    int roll() {
        (0..<rolls).collect { rng.nextInt(die) + 1 }.sum() + modifier
    }

    String toString() {
        "${rolls > 1 ? rolls : ''}d${die}${ modifier ? '+' + modifier : ''}"
    }

    static Dice parse(String expr) {
        Matcher matcher = pattern.matcher(expr)
        if (matcher.matches()) {
            return new Dice(toi(matcher.group(1), '1'), matcher.group(2) as int, toi(matcher.group(3)))

        } else {
            throw new RuntimeException("Invalid dice expression: $expr")
        }
    }

    static int d20() {
        rng.nextInt(20) + 1
    }

    private static int toi(String str, String defval = '0') {
        (str ?: defval) as int
    }
}
