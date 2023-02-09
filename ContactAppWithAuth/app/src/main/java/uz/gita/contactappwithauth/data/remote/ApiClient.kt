package uz.gita.contactappwithauth.data.remote

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.contactappwithauth.app.App

object ApiClient {
    private val okHttp = OkHttpClient.Builder()
        .addInterceptor(ChuckInterceptor(App.instance))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://c55c-217-30-173-145.ngrok.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp)
        .build()
}

