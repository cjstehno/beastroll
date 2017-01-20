package com.stehno.beast

import groovy.transform.Immutable
import groovy.transform.TupleConstructor

import static com.stehno.beast.Dice.parse

/**
 * Created by cjstehno on 1/20/17.
 */
@TupleConstructor
class Beast {

    final String name

    private final List<Attack> attacks = []

    void attack(String type, String damage) {
        attack type, 'd20', damage
    }

    void attack(String type, String hit, String damage) {
        attacks << new Attack(type, parse(hit), parse(damage))
    }

    Iterable<Attack> attacks() {
        attacks.asImmutable()
    }

    List<AttackRoll> rolls() {
        attacks.collect { att ->
            new AttackRoll(att.type, att.hit.roll(), att.damage.roll())
        }
    }
}

@Immutable
class AttackRoll {
    String type
    int hit
    int damage
}