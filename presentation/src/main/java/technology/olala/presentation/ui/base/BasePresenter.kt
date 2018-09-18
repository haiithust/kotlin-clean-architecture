package technology.olala.presentation.ui.base


import io.reactivex.disposables.CompositeDisposable
import technology.olala.domain.constant.LocalConst
import technology.olala.domain.interactor.BaseObserver
import technology.olala.domain.interactor.UseCase
import technology.olala.domain.response.ErrorResponse
import technology.olala.presentation.response.ResponseMessageFactory

/**
 * @author conghai on 7/9/18.
 */
abstract class BasePresenter<V : BaseCallback> {
    protected var callback: V? = null
    private val mCompositeDisposable = CompositeDisposable()

    constructor() {

    }

    constructor(callback: V) {
        this.callback = callback
    }

    fun create() {

    }

    fun start() {

    }

    fun pause() {

    }

    fun destroy() {
        mCompositeDisposable.clear()
    }

    protected fun <T, P> executeTask(useCase: UseCase<T, P>, param: P, observer: BaseObserver<T>) {
        mCompositeDisposable.add(useCase.execute(observer, param))
    }

    protected fun handleError(errorResponse: ErrorResponse) {
        if (errorResponse.errorCode == LocalConst.ERROR.NO_NETWORK_CONNECTION) {
            this.callback?.showNoNetworkAvailable()
        } else {
            this.callback?.showError(ResponseMessageFactory.getResStringByResponse(errorResponse))
        }
    }
}
