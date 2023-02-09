package uz.gita.contactappwithauth.data.local

import android.content.Context
import uz.gita.contactappwithauth.app.App

class MySharedPref private constructor() {
    companion object {
        private val instance = MySharedPref()
        private val pref = App.instance.getSharedPreferences("Contact", Context.MODE_PRIVATE)

        fun getMySharedPref(): MySharedPref {
            return instance
        }
    }

    var token: String
        get() = pref.getString("TOKEN", "")!!
        set(value) = pref.edit().putString("TOKEN", value).apply()
}