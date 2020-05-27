package technology.olala.presentation.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import technology.olala.data.net.ApiConnection
import technology.olala.presentation.di.module.NetworkModule
import technology.olala.presentation.di.module.SchedulerModule
import technology.olala.presentation.scheduler.CoroutinesDispatcherProvider
import javax.inject.Singleton

/**
 * @author conghai on 7/7/18.
 */
@Singleton
@Component(modules = [NetworkModule::class, SchedulerModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun application(): Application
    fun apiConnection(): ApiConnection
    fun dispatcher(): CoroutinesDispatcherProvider
}
