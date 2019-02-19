package com.treehouse.domainname.retrofit

import com.treehouse.domainname.network.DomainServices
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent {
    fun domainServices(): DomainServices
}