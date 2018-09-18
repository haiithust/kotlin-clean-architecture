package technology.olala.data.cache.impl

import technology.olala.data.cache.UserCached
import technology.olala.data.entity.CityInfoEntity
import technology.olala.data.entity.mapper.CityInfoEntityMapper
import technology.olala.domain.model.CityInfo
import javax.inject.Inject

/**
 * @author conghai on 7/7/18.
 */
class UserCachedImpl @Inject
internal constructor(private val mSharePreferenceCached: SharePreferenceCached, private val mDatabaseCached: DatabaseCached, private val mFileCached: FileCached)
    : UserCached {
    override val cityInfo: List<CityInfo>
        get() {
            var cityInfoEntityList: List<CityInfoEntity> = mDatabaseCached.cityInfoEntityList
            if (cityInfoEntityList.isEmpty()) {
                cityInfoEntityList = mFileCached.loadCityInfoList()
                mDatabaseCached.storeCityInfo(cityInfoEntityList)
            }
            return CityInfoEntityMapper().map(cityInfoEntityList)
        }

    override fun storeCityInfo(cityInfoList: List<CityInfo>) {
        mDatabaseCached.storeCityInfo(CityInfoEntityMapper().revertMap(cityInfoList))
    }
}
