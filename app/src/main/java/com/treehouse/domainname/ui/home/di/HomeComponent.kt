package com.treehouse.domainname.ui.home.di

import com.treehouse.domainname.retrofit.AppComponent
import com.treehouse.domainname.ui.home.MainActivity

import dagger.Component

@Component(dependencies = [AppComponent::class], modules = [HomeModule::class])
@HomeScope
interface HomeComponent {
    fun inject(mainActivity: MainActivity)
}