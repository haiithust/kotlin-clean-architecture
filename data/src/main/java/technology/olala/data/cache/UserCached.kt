package technology.olala.data.cache

import technology.olala.domain.model.CityInfo

/**
 * @author conghai on 7/7/18.
 */
interface UserCached {
    val cityInfo: List<CityInfo>
    fun storeCityInfo(cityInfoList : List<CityInfo>)
}
