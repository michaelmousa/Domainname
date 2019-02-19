package com.treehouse.domainname.ui.home

interface HomeContract{

    interface View {
        fun showResults(result:String)
        fun showError(message: String)
    }
    interface Presenter{
        fun getDomainDetails(domain:String)
    }
}