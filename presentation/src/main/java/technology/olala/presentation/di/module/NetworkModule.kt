package technology.olala.presentation.di.module


import dagger.Module
import dagger.Provides
import technology.olala.data.net.ApiConnection
import javax.inject.Singleton

/**
 * @author conghai on 7/17/18.
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideApiConnection(): ApiConnection {
        return ApiConnection()
    }
}
