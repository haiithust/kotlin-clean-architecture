package technology.olala.domain.scheduler

import io.reactivex.Scheduler

/**
 * @author conghai on 7/7/18.
 */
interface ResultScheduler {
    val scheduler: Scheduler
}
