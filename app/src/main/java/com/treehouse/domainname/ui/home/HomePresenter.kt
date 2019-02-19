package com.treehouse.domainname.ui.home

import com.treehouse.domainname.network.DomainServices
import java.net.SocketException
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomePresenter  (

    private val domainServices: DomainServices,
    private val view: HomeContract.View): HomeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getDomainDetails(domain:String) {

        compositeDisposable.add(domainServices.getDomainDetails(domain.toString())
            .subscribeOn(Schedulers.io())
            .map { it.domain }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view.showResults(it) },

                { failure ->
                    if (failure is SocketException) {
                        view.showError("Domain Error")
                    } else {
                        view.showError(failure?.message ?: "An unknown error happened")
                    }}))}}




//        //DomainServices.getDomainDetails(domain: String).enqueue(object : Callback<DomainData> {
//
//            //override fun onResponse(call: Call<DomainData>, response: Response<DomainData>) {
//
//              //  if (response.isSuccessful) {
////
//                    view.showResults(response.body()?.domain ?: "")
//                }
//                else {
//                    view.showError("An unknown error occurred")
//                }            }
//            override fun onFailure(call: Call<DomainData>, t: Throwable) {
//                view.showError("Please try again")
//            }
//        })




