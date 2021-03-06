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
        beast('giant-bat'){
            attack 'bite', 'd20+4', 'd6+2'
        }
        beast('flying-snake'){
            attack 'bite (poison)', 'd20+6', '3d4+1'
        }
        beast('giant-eagle'){
            attack 'beak', 'd20+5', 'd6+3'
            attack 'talons', 'd20+5', '2d6+3'
        }        
        beast('giant-constrictor-snake'){
            attack 'bite', 'd20+6', '2d6+4'
            attack 'contrict', 'd20+6', '2d6+4'
        }
        beast('giant-crocodile'){
            attack 'bite', 'd20+8', '3d10+5'
            attack 'tail', 'd20+8', '2d8+5'
        }  
        beast('reef-shark'){
            attack 'bite', 'd20+4', 'd8+2'
        }
        beast('giant-octopus'){
            attack 'tentacles', 'd20+5', '2d6+3'
        }
        beast('dire-wolf'){
            attack 'bite', 'd20+5', '2d6+3' 
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
