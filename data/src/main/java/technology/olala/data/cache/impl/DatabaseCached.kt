package technology.olala.data.cache.impl

import technology.olala.data.entity.CityInfoEntity
import technology.olala.data.entity.DaoMaster
import technology.olala.data.entity.DaoSession
import javax.inject.Inject

/**
 * @author conghai on 7/7/18.
 */
class DatabaseCached
@Inject
internal constructor(databaseOpenHelper: DatabaseOpenHelper) {
    private val mDaoSession : DaoSession = DaoMaster(databaseOpenHelper.writableDb).newSession()

    fun storeCityInfo(cityInfoEntityList: List<CityInfoEntity>) {
        mDaoSession.cityInfoEntityDao.insertOrReplaceInTx(cityInfoEntityList)
    }

    val cityInfoEntityList : List<CityInfoEntity> = mDaoSession.cityInfoEntityDao.loadAll()
}
