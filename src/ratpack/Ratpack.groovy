import com.stehno.beast.Beast
import com.stehno.beast.BeastModule
import com.stehno.beast.Beasts
import com.stehno.beast.Dice
import ratpack.groovy.template.TextTemplateModule

import static ratpack.groovy.Groovy.groovyTemplate
import static ratpack.groovy.Groovy.ratpack

ratpack {
    bindings {
        module TextTemplateModule
        module BeastModule
    }

    handlers {
        get('roll/:dice/:mod') {
            def dice = Dice.parse("${pathTokens.dice}+${pathTokens.mod}")
            render "$dice: ${dice.roll()}"
        }
        get('roll/:dice') {
            def dice = Dice.parse("${pathTokens.dice}")
            render "$dice: ${dice.roll()}"
        }

        get('beasts') {
            render groovyTemplate('beasts.html', beasts: registry.get(Beasts).beasts())
        }

        get('rolls/:beast/:number'){
            Beast beast = registry.get(Beasts)[pathTokens.beast]

            if( beast ){
                render groovyTemplate('rolls.html', beast: beast, count:pathTokens.number as int)
            } else {
                render 'Not found!'
            }
        }
        get('rolls/:beast'){
            Beast beast = registry.get(Beasts)[pathTokens.beast]

            if( beast ){
                render groovyTemplate('rolls.html', beast: beast, count:1)
            } else {
                render 'Not found!'
            }
        }

        get {
            render groovyTemplate('index.html')
        }

        files { dir 'public' }
    }
}
