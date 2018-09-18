package technology.olala.domain.interactor

import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import technology.olala.domain.scheduler.ResultScheduler
import technology.olala.domain.scheduler.WorkScheduler

/**
 * @author conghai on 7/7/18.
 */
abstract class UseCase<T, Params> internal constructor(private val workScheduler: WorkScheduler, private val resultScheduler: ResultScheduler) {
    private var disposables: DisposableObserver<T>? = null

    internal abstract fun buildUseCaseObservable(params: Params?): Observable<T>

    fun execute(observer: BaseObserver<T>, params: Params?): DisposableObserver<T>? {
        disposables = this.buildUseCaseObservable(params)
                .subscribeOn(workScheduler.scheduler)
                .observeOn(resultScheduler.scheduler).subscribeWith(observer.subscriber)
        return disposables
    }

    fun dispose() {
        if (disposables?.isDisposed!!) {
            disposables?.dispose()
        }
    }
}
