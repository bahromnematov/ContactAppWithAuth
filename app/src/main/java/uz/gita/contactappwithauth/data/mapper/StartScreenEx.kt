package uz.gita.contactappwithauth.data.mapper

import uz.gita.contactappwithauth.data.model.StartScreenEnum

fun String.toStartScreenEnum() : StartScreenEnum {
    return when(this) {
        "LOGIN" -> StartScreenEnum.LOGIN
        else -> StartScreenEnum.CONTACT
    }
}

