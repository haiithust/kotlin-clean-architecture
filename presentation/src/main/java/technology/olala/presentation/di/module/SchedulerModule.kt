package technology.olala.presentation.di.module

import dagger.Module
import dagger.Provides
import technology.olala.data.scheduler.WorkSchedulerImpl
import technology.olala.domain.scheduler.ResultScheduler
import technology.olala.domain.scheduler.WorkScheduler
import technology.olala.presentation.scheduler.ResultSchedulerImpl
import javax.inject.Singleton

/**
 * @author conghai on 7/17/18.
 */
@Module
class SchedulerModule {
    @Provides
    @Singleton
    internal fun provideWorkScheduler(): WorkScheduler {
        return WorkSchedulerImpl()
    }

    @Provides
    @Singleton
    internal fun provideResultScheduler(): ResultScheduler {
        return ResultSchedulerImpl()
    }
}
