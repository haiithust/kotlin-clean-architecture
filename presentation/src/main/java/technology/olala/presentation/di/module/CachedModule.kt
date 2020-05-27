package technology.olala.presentation.di.module


import dagger.Binds
import dagger.Module
import technology.olala.data.cache.impl.DatabaseCached
import technology.olala.data.cache.impl.FileCached
import technology.olala.data.cache.impl.SharePreferenceCached
import technology.olala.presentation.di.scope.UserScope

/**
 * @author conghai on 7/17/18.
 */
@Module
abstract class CachedModule {
    @Binds
    @UserScope
    abstract fun provideSharePreferenceCached(cached: SharePreferenceCached): SharePreferenceCached

    @Binds
    @UserScope
    abstract fun provideFileCached(cached: FileCached): FileCached

    @Binds
    @UserScope
    abstract fun provideDatabaseCached(cached: DatabaseCached): DatabaseCached
}
