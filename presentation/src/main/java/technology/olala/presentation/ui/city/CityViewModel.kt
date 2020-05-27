package technology.olala.presentation.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.map
import technology.olala.domain.interactor.GetCityListUseCase
import technology.olala.domain.model.CityInfo
import technology.olala.domain.response.Loading
import technology.olala.domain.response.Result
import technology.olala.domain.response.Success
import technology.olala.presentation.model.CityInfoModel
import technology.olala.presentation.scheduler.CoroutinesDispatcherProvider
import technology.olala.presentation.ui.base.BaseViewModel
import technology.olala.presentation.ui.util.execute
import javax.inject.Inject

/**
 * @author conghai on 8/25/18.
 */
class CityViewModel @Inject constructor(
        dispatcher: CoroutinesDispatcherProvider,
        getCityListUseCase: GetCityListUseCase
) : BaseViewModel(dispatcher) {
    private val citiesResult = MutableLiveData<Result<List<CityInfo>>>()
    val cityList: LiveData<List<CityInfoModel>> = citiesResult.map {
        if (it is Success)
            it.data.map { item -> CityInfoModel(item.cityId, item.cityName, item.countryCode, item.latitude, item.longitude) }
        else emptyList()
    }.distinctUntilChanged()

    val isLoading: LiveData<Boolean> = citiesResult.map { it is Loading }

    init {
        execute(getCityListUseCase, Unit, citiesResult)
    }
}