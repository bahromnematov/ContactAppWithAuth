package uz.gita.contactappwithauth.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import uz.gita.contactappwithauth.data.local.AppPreferences
import uz.gita.contactappwithauth.domain.repository.impl.AuthRepositoryImpl

@HiltAndroidApp
class App : Application()

