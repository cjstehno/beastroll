package com.stehno.beast

class Beasts {

    private final Map<String, Beast> beasts = [:]

    Beasts() {
        beast('elk') {
            attack 'ram', 'd20+5', 'd6+3'
            attack 'hooves', 'd20+5', '2d4+3'
        }
        beast('giant-elk') {
            attack 'ram', 'd20+6', '2d6+4'
            attack 'hooves', 'd20+6', '4d8+4'
        }        
        beast('giant-badger') {
            attack 'bite', 'd20+3', 'd6+1'
            attack 'claw', 'd20+3', '2d4+1'
        }
        beast('elephant'){
            attack 'gore', 'd20+8', '3d8+5'
            attack 'stomp', 'd20+8', '3d10+5'
        }
        beast('black-bear'){
            attack 'bite', 'd20+3', 'd6+2'
            attack 'claw', 'd20+3', '2d4+2'
        }        
        beast('brown-bear'){
            attack 'bite', 'd20+5', 'd8+4'
            attack 'claw', 'd20+5', '2d6+4'
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
