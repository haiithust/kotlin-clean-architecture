package technology.olala.data.repository

import technology.olala.data.cache.impl.DatabaseCached
import technology.olala.data.cache.impl.FileCached
import technology.olala.domain.model.CityInfo
import technology.olala.domain.response.Error
import technology.olala.domain.response.Result
import technology.olala.domain.response.Success
import technology.olala.domain.repository.CityRepository
import java.io.IOException
import javax.inject.Inject

/**
 * @author conghai on 8/26/18.
 */
class CityRepositoryImpl @Inject
constructor(private val databaseCached: DatabaseCached, private val fileCached: FileCached) : CityRepository {

    override suspend fun getCityList(): Result<List<CityInfo>> {
        val entities = databaseCached.cityEntities
        if (entities is Success) {
            if (entities.data.isEmpty()) {
                val result = fileCached.loadCityInfoList()
                if (result is Success) {
                    databaseCached.storeCityInfo(result.data)
                    return Success(result.data.map { CityInfo(it.cityId.toInt(), it.cityName, it.country, it.latitude, it.longitude) })
                }
            }
            return Success(entities.data.map { CityInfo(it.cityId.toInt(), it.cityName, it.country, it.latitude, it.longitude) })
        }
        return Error(IOException("Empty data"))
    }
}