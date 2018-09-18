package technology.olala.presentation.di.component

import android.content.Context
import dagger.Component
import technology.olala.data.net.ApiConnection
import technology.olala.domain.scheduler.ResultScheduler
import technology.olala.domain.scheduler.WorkScheduler
import technology.olala.presentation.di.module.ApplicationModule
import technology.olala.presentation.di.module.NetworkModule
import technology.olala.presentation.di.module.SchedulerModule
import javax.inject.Singleton

/**
 * @author conghai on 7/7/18.
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, SchedulerModule::class])
interface ApplicationComponent {
    val applicationContext: Context
    fun apiConnection(): ApiConnection
    fun workScheduler(): WorkScheduler
    fun resultScheduler(): ResultScheduler
}
