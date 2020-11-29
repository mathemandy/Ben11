package ng.mathemandy.venten.remote

import ng.mathemandy.venten.BuildConfig
import ng.mathemandy.venten.data.model.BaseRates
import ng.mathemandy.venten.data.model.Filter
import retrofit2.http.GET
import retrofit2.http.Query


interface  ApiService {

    @GET("latest")
    suspend fun  fetchBaseRates(@Query("access_key") accessToken : String = BuildConfig.ACCESS_KEY) : BaseRates

}