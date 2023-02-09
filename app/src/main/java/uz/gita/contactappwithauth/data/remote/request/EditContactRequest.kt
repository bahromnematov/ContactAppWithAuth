package uz.gita.mycontactbyretrofit.data.remote.request

data class EditContactRequest(
    val id : Int,
    val firstName: String,
    val lastName : String,
    val phone : String
)