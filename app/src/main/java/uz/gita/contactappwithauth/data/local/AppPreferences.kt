package uz.gita.contactappwithauth.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.gita.contactappwithauth.data.mapper.toStartScreenEnum
import uz.gita.contactappwithauth.data.model.StartScreenEnum
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(@ApplicationContext context: Context) {
    private var pref: SharedPreferences = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE)

    var startScreen: StartScreenEnum
        set(value) = pref.edit().putString("START_SCREEN", value.name).apply()
        get() = pref.getString("START_SCREEN", "LOGIN")!!.toStartScreenEnum()

    var token: String
        set(value) = pref.edit().putString("TOKEN", value).apply()
        get() = pref.getString("TOKEN", "")!!
}