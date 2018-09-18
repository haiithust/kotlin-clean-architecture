package technology.olala.domain.repository

import io.reactivex.Observable
import technology.olala.domain.model.CityInfo

/**
 * @author conghai on 8/9/18.
 */
interface CityRepository {
    val cityList: Observable<List<CityInfo>>
}