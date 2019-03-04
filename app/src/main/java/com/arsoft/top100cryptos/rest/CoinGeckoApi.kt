package com.arsoft.top100cryptos.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {


    //requesting list of cryptos
    @GET("coins/markets")
    fun getCoinMarket(
        @Query("vs_currency") vs: String = "usd",
        @Query("per_page") perPage: Int = 100,
        @Query("sparkline") sparkLine: Boolean = false,
        @Query("order") order: String = "market_cap_desc"
    ): Observable<List<GeckoCoin>>

    //requesting data for shedule
    @GET("coins/{id}/market)chart")
    fun getCoinMarketChart(
        @Path("id") id: String,
        @Query("vs_currency") vs: String = "usd",
        @Query("days") days: String = "max"
    ): Observable<List<GeckoCoinChart>>
}