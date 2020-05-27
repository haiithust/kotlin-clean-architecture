package technology.olala.data.cache.impl

import technology.olala.data.entity.CityInfoEntity
import technology.olala.data.entity.DaoMaster
import technology.olala.data.entity.DaoSession
import technology.olala.domain.response.Result
import technology.olala.domain.response.Success
import javax.inject.Inject

/**
 * @author conghai on 7/7/18.
 */
class DatabaseCached @Inject
constructor(databaseOpenHelper: DatabaseOpenHelper) {
    private val mDaoSession: DaoSession = DaoMaster(databaseOpenHelper.writableDb).newSession()

    fun storeCityInfo(cityInfoEntityList: List<CityInfoEntity>) {
        mDaoSession.cityInfoEntityDao.insertOrReplaceInTx(cityInfoEntityList)
    }

    val cityEntities: Result<List<CityInfoEntity>> = Success(mDaoSession.cityInfoEntityDao.loadAll())
}
