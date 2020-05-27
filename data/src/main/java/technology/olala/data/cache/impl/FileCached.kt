package technology.olala.data.cache.impl

import android.app.Application
import technology.olala.data.entity.CityInfoEntity
import technology.olala.data.entity.CityListJson
import technology.olala.data.util.ParseUtils
import technology.olala.domain.response.Error
import technology.olala.domain.response.Result
import technology.olala.domain.response.Success
import java.io.IOException
import javax.inject.Inject

/**
 * @author conghai on 8/26/18.
 */
class FileCached @Inject
constructor(private val application: Application) {
    fun loadCityInfoList(): Result<List<CityInfoEntity>> {
        return try {
            val cityListJson = ParseUtils.gson.fromJson(loadJsonFromAsset(), CityListJson::class.java)
            Success(cityListJson.cityList.map { value -> CityInfoEntity(value.cityId, value.cityName, value.countryCode, value.latitude, value.longitude) })
        } catch (e: Exception) {
            Error(e)
        }
    }

    private fun loadJsonFromAsset(): String? {
        try {
            val inputStream = application.assets.open("city.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return null
    }
}