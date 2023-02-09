package uz.gita.mycontactbyretrofit.data.remote.response

data class ContactResponse(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phone: String
)

/*
[
    {
        "id": 1,
        "firstName": "Example",
        "lastName": "Sample",
        "phone": "+998946309344"
    },
    {
        "id": 2,
        "firstName": "Example_2",
        "lastName": "Sample_2",
        "phone": "+998946309343"
    }
]
* */