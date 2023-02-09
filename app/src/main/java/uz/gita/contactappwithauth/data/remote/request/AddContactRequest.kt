package uz.gita.mycontactbyretrofit.data.remote.request

data class AddContactRequest(
    val firstName: String,
    val lastName: String,
    val phone: String
)