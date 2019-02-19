package com.treehouse.domainname

import android.app.Application
import com.treehouse.domainname.retrofit.AppComponent
import com.treehouse.domainname.retrofit.DaggerAppComponent

class App : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build();
    }
    fun getComponent() = appComponent
}