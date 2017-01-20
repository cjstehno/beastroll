package com.stehno.beast

class Beasts {

    private final Map<String, Beast> beasts = [:]

    Beasts() {
        beast('elk') {
            attack 'ram', 'd20+5', 'd6+3'
            attack 'hooves', 'd20+5', '2d4+3'
        }
        beast('giant-badger') {
            attack 'bite', 'd20+3', 'd6+1'
            attack 'claw', 'd20+3', '2d4+1'
        }
        beast('elephant'){
            attack 'gore', 'd20+8', '3d8+5'
            attack 'stomp', 'd20+8', '3d10+5'
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
