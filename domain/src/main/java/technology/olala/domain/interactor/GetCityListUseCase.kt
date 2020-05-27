package technology.olala.domain.interactor

import technology.olala.domain.model.CityInfo
import technology.olala.domain.response.Result
import technology.olala.domain.repository.CityRepository
import javax.inject.Inject

/**
 * @author conghai on 8/26/18.
 */
class GetCityListUseCase
@Inject constructor(private val repository: CityRepository) : CoroutineUseCase<Unit, List<CityInfo>>() {
    override suspend fun invoke(params: Unit): Result<List<CityInfo>> = repository.getCityList()
}