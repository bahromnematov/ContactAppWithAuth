package uz.gita.contactappwithauth.data.remote.requests

data class LoginRequest(
    val phone : String,
    val password : String
)

/*
{
    "phone":"+998931433836",
    "password":"1234567"
}
* */