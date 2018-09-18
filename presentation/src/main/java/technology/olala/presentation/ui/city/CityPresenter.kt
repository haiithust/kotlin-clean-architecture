package technology.olala.presentation.ui.city

import technology.olala.domain.interactor.BaseObserver
import technology.olala.domain.interactor.GetCityInfoList
import technology.olala.domain.model.CityInfo
import technology.olala.domain.response.ErrorResponse
import technology.olala.presentation.model.mapper.CityInfoModelMapper
import technology.olala.presentation.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author conghai on 8/25/18.
 */
class CityPresenter(cityCallback: CityCallback) : BasePresenter<CityCallback>(cityCallback) {
    @Inject lateinit var mGetCityInfoList: GetCityInfoList

    public fun getCityInfoList() {
        callback?.showLoading()
        executeTask(mGetCityInfoList, Any(), object : BaseObserver<List<CityInfo>>() {
            override fun onBeforeEnd(isSuccess: Boolean) {
                super.onBeforeEnd(isSuccess)
                callback?.hideLoading()
            }
            override fun onHandleSuccess(t: List<CityInfo>) {
                super.onHandleSuccess(t)
                callback?.getCityInfoListSuccess(CityInfoModelMapper().map(t))
            }

            override fun onHandleError(errorResponse: ErrorResponse) {
                super.onHandleError(errorResponse)
                callback?.getCityInfoListSuccess(ArrayList())
            }
        })
    }
}