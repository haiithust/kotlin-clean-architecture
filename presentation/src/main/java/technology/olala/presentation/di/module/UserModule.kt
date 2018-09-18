package technology.olala.presentation.di.module


import android.content.Context

import dagger.Module
import dagger.Provides
import technology.olala.data.cache.UserCached
import technology.olala.data.repository.CityRepositoryImpl
import technology.olala.data.repository.ContactRepositoryImpl
import technology.olala.data.repository.UserSettingRepositoryImpl
import technology.olala.domain.repository.CityRepository
import technology.olala.domain.repository.ContactRepository
import technology.olala.domain.repository.UserSettingRepository
import technology.olala.presentation.di.scope.UserScope

/**
 * @author conghai on 7/17/18.
 */
@Module
class UserModule {
    @Provides
    @UserScope
    internal fun provideSettingRepository(userCached: UserCached): UserSettingRepository {
        return UserSettingRepositoryImpl(userCached)
    }

    @Provides
    @UserScope
    internal fun provideContactRepository(context: Context): ContactRepository {
        return ContactRepositoryImpl(context)
    }

    @Provides
    @UserScope
    internal fun provideCityRepository(userCached: UserCached) : CityRepository  {
        return CityRepositoryImpl(userCached)
    }
}
