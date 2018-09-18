package technology.olala.domain.interactor

import io.reactivex.observers.DisposableObserver
import technology.olala.domain.response.ErrorNetworkResponse
import technology.olala.domain.response.ErrorResponse
import technology.olala.domain.response.ErrorUnknow
import java.net.UnknownHostException

/**
 * @author conghai on 7/7/18.
 */
abstract class BaseObserver<T> {
    val subscriber: DisposableObserver<T>

    init {
        subscriber = object : DisposableObserver<T>() {
            override fun onStart() {
                super.onStart()
                onSubscriber()
            }

            override fun onComplete() {
                onBeforeEnd(true)
            }

            override fun onError(e: Throwable?) {
                onBeforeEnd(false)

                if (e != null) {
                    if (e is ErrorResponse) {
                        onHandleError(e)
                    } else {
                        if (e is UnknownHostException) {
                            onHandleError(ErrorNetworkResponse())
                        } else {
                            onHandleError(ErrorUnknow(e))
                        }
                    }
                } else {
                    onHandleError(ErrorUnknow(e))
                }
            }

            override fun onNext(t: T) {
                onHandleSuccess(t)
            }
        }
    }

    protected open fun onSubscriber() {

    }

    protected open fun onHandleSuccess(t: T) {

    }

    protected open fun onBeforeEnd(isSuccess: Boolean) {

    }

    protected open fun onHandleError(errorResponse: ErrorResponse) {

    }
}
