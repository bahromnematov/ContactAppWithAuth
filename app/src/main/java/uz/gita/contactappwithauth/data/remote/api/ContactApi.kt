package uz.gita.contactappwithauth.data.remote.api

import retrofit2.Call
import retrofit2.http.*
import uz.gita.mycontactbyretrofit.data.remote.request.AddContactRequest
import uz.gita.mycontactbyretrofit.data.remote.request.EditContactRequest
import uz.gita.mycontactbyretrofit.data.remote.response.ContactResponse

interface ContactApi {

    @GET("/contact")
    fun getAllContact(@Header("token") token : String) : Call<List<ContactResponse>>

    @POST("/api/v1/contact")
    fun addContact(@Header("token") token : String, @Body data : AddContactRequest) : Call<ContactResponse>

    @PUT("/api/v1/contact")
    fun editContact(@Header("token") token : String, @Body data: EditContactRequest) : Call<ContactResponse>

    @DELETE("/api/v1/contact")
    fun deleteContact(@Header("token") token : String, @Query("id") id : Int) : Call<Unit>
}

