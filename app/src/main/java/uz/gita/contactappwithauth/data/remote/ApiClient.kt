package uz.gita.contactappwithauth.data.remote

import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.contactappwithauth.app.App

/*object ApiClient {

//    private val myClient = OkHttpClient.Builder()
//        .addInterceptor(ChuckInterceptor(App.instance))
//        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://ede2-217-30-173-145.ngrok.io")
//        .client(myClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}*/

