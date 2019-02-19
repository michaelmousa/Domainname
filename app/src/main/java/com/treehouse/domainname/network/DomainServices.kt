package com.treehouse.domainname.network

import com.treehouse.domainname.model.DomainData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface DomainServices {
    @GET(END_POINT)
    fun getDomainDetails(@Path("domain") domain: String): Observable<DomainData>
}