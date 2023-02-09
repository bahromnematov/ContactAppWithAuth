package uz.gita.contactappwithauth.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactappwithauth.domain.repository.AuthRepository
import uz.gita.contactappwithauth.domain.repository.impl.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun getAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}






/*
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @[Provides Singleton]
    fun getAuthRepository(autApi: AuthApi, pref: AppPreferences, gson: Gson): AuthRepository = AuthRepositoryImpl(autApi, pref, gson)
}
* */
