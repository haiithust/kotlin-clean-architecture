package technology.olala.domain.repository

import technology.olala.domain.model.CityInfo
import technology.olala.domain.response.Result

/**
 * @author conghai on 8/9/18.
 */
interface CityRepository {
    suspend fun getCityList(): Result<List<CityInfo>>
}