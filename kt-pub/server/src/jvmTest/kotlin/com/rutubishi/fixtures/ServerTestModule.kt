package com.rutubishi.fixtures

import com.rutubishi.di.sharedServerModule
import org.koin.dsl.module

val serverTestModule = module {
    sharedServerModule {

    }
}