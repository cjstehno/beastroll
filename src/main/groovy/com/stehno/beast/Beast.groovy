package com.stehno.beast

import groovy.transform.Immutable
import groovy.transform.TupleConstructor

/**
 * Created by cjstehno on 1/20/17.
 */
@TupleConstructor
class Beast {

    final String name

    private final List<Attack> attacks = []

    void attack(String type, String damage) {
        attacks << new Attack(type, Dice.parse(damage))
    }

    Iterable<Attack> attacks() {
        attacks.asImmutable()
    }

    List<AttackRoll> rolls() {
        attacks.collect { att ->
            new AttackRoll(att.type, Dice.d20(), att.damage.roll())
        }
    }
}

@Immutable
class AttackRoll {
    String type
    int hit
    int damage
}