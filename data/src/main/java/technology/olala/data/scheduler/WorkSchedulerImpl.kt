package technology.olala.data.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import technology.olala.domain.scheduler.WorkScheduler

/**
 * @author conghai on 7/7/18.
 */
class WorkSchedulerImpl : WorkScheduler {
    override val scheduler: Scheduler = Schedulers.computation()
}
