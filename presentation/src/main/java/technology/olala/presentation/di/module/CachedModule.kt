package technology.olala.presentation.di.module


import dagger.Module
import dagger.Provides
import technology.olala.data.cache.UserCached
import technology.olala.data.cache.impl.UserCachedImpl
import technology.olala.presentation.di.scope.UserScope

/**
 * @author conghai on 7/17/18.
 */
@Module
class CachedModule {
    @Provides
    @UserScope
    internal fun provideDataCached(dataCached: UserCachedImpl): UserCached {
        return dataCached
    }
}
