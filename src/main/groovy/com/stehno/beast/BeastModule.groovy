package com.stehno.beast

import com.google.inject.AbstractModule

/**
 * Created by cjstehno on 1/20/17.
 */
class BeastModule extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Beasts).asEagerSingleton()
    }
}
