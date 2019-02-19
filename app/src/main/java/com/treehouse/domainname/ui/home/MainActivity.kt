package com.treehouse.domainname.ui.home


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.treehouse.domainname.App
import com.treehouse.domainname.R
import com.treehouse.domainname.ui.home.di.DaggerHomeComponent
import com.treehouse.domainname.ui.home.di.HomeModule
import kotlinx.android.synthetic.main.activity_main.*


import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {
    @Inject
    lateinit var homePresenter: HomeContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        btnDomain.setOnClickListener {
            homePresenter.getDomainDetails(edDomain.text.toString()) }
    }
    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()    }

    override fun showResults(result: String) {
        tvResult.text = result
    }
}