package uz.gita.contactappwithauth.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import uz.gita.contactappwithauth.domain.repository.AuthRepository
import uz.gita.contactappwithauth.domain.usecase.LoginUseCase
import uz.gita.contactappwithauth.domain.usecase.StartScreenUseCase
import uz.gita.contactappwithauth.domain.usecase.impl.LoginUseCaseImpl
import uz.gita.contactappwithauth.domain.usecase.impl.StartScreenUseCaseImpl
import uz.gita.contactappwithauth.utils.ConnectionUtil
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun getLoginUseCase(impl : LoginUseCaseImpl) : LoginUseCase

    @Binds
    fun getStartScreenUseCase(impl : StartScreenUseCaseImpl) : StartScreenUseCase
}

//@Module
//@InstallIn(SingletonComponent::class)
//class UseCaseExample() {
//
//    @[Provides Singleton]
//    fun getLoginUseCaseImpl(repository: AuthRepository) : LoginUseCaseImpl = LoginUseCaseImpl(repository)
//}

