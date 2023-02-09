package uz.gita.contactappwithauth.app

import android.app.Application
import uz.gita.contactappwithauth.data.local.MySharedPref

class App : Application() {
    companion object {
        lateinit var instance : App
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}