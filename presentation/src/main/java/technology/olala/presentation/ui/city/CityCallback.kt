package technology.olala.presentation.ui.city

import technology.olala.presentation.model.CityInfoModel
import technology.olala.presentation.ui.base.BaseCallback

/**
 * @author conghai on 8/25/18.
 */
interface CityCallback : BaseCallback {
    fun getCityInfoListSuccess(cityInfoModelList: List<CityInfoModel>)
}