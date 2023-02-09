package uz.gita.contactappwithauth.data.remote.requests

data class RegisterRequest(
    val firstName: String,
    val lastName: String,
    val phone: String,
    val password: String
)

/*
{
    "firstName": "Muhammad",
    "lastName":"Murodullayev",
    "phone":"+998931433836",
    "password":"1234657"
}
* */