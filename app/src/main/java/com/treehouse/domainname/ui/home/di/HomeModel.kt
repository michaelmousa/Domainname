package com.treehouse.domainname.ui.home.di

import com.treehouse.domainname.network.DomainServices
import com.treehouse.domainname.ui.home.HomeContract
import com.treehouse.domainname.ui.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val view: HomeContract.View) {

    @HomeScope
    @Provides
    fun provideHomePresenter(DomainServices: DomainServices)
            : HomeContract.Presenter {
        return HomePresenter(DomainServices, view)
    }
}