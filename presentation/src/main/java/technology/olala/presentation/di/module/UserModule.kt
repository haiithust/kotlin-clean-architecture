package technology.olala.presentation.di.module


import dagger.Binds
import dagger.Module
import technology.olala.data.repository.CityRepositoryImpl
import technology.olala.data.repository.ContactRepositoryImpl
import technology.olala.domain.repository.CityRepository
import technology.olala.domain.repository.ContactRepository
import technology.olala.presentation.di.scope.UserScope

/**
 * @author conghai on 7/17/18.
 */
@Module
abstract class UserModule {
    @Binds
    @UserScope
    abstract fun provideContactRepository(repository: ContactRepositoryImpl): ContactRepository

    @Binds
    @UserScope
    abstract fun provideCityRepository(repository: CityRepositoryImpl) : CityRepository
}
