package technology.olala.presentation.di.module

import dagger.Module
import dagger.Provides
import technology.olala.presentation.scheduler.CoroutinesDispatcherProvider
import javax.inject.Singleton

/**
 * @author conghai on 7/17/18.
 */
@Module
class SchedulerModule {

    @Provides
    @Singleton
    fun provideCoroutinesDispatcher() : CoroutinesDispatcherProvider {
        return CoroutinesDispatcherProvider()
    }
}
