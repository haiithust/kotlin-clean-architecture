package technology.olala.presentation.scheduler

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import technology.olala.domain.scheduler.ResultScheduler

/**
 * @author conghai on 7/7/18.
 */
class ResultSchedulerImpl : ResultScheduler {

    override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}
