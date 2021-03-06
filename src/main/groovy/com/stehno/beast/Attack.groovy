package com.stehno.beast

import groovy.transform.Immutable

/**
 * Created by cjstehno on 1/20/17.
 */
@Immutable
class Attack {
    String type
    Dice hit
    Dice damage

    @Override String toString(){
        "$type ($hit to hit, $damage damage)"
    }
}
