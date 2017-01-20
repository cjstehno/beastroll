package com.stehno.beast

class Beasts {

    private final Map<String, Beast> beasts = [:]

    Beasts() {
        beast('elk') {
            attack 'hoof', 'd6'
            attack 'hoof', 'd6'
            attack 'antler', 'd8+1'
        }
        beast('badger') {
            attack 'claw', 'd4'
            attack 'claw', 'd4'
            attack 'bite', '2d4'
        }
    }

    void beast(String name, @DelegatesTo(Beast) Closure closure) {
        Beast beast = new Beast(name)
        closure.delegate = beast
        closure()
        beasts[name] = beast
    }

    Beast getAt(String name) {
        beasts[name]
    }

    Iterable<Beast> beasts() {
        beasts.values().asImmutable()
    }
}
