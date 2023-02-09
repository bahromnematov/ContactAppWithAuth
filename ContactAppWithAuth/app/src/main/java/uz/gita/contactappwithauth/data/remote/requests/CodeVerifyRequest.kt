package uz.gita.contactappwithauth.data.remote.requests

data class CodeVerifyRequest(
    val phone: String,
    val code: String
)


/*
{
    "phone":"+998931433836",
    "code":"783299"
}
* */