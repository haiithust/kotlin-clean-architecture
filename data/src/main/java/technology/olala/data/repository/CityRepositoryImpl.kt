package technology.olala.data.repository

import io.reactivex.Observable
import technology.olala.data.cache.UserCached
import technology.olala.domain.model.CityInfo
import technology.olala.domain.repository.CityRepository

/**
 * @author conghai on 8/26/18.
 */
class CityRepositoryImpl(private val mUserCached: UserCached) : CityRepository {
    override val cityList: Observable<List<CityInfo>>
        get() = Observable.fromCallable<List<CityInfo>> { mUserCached.cityInfo }
}