package technology.olala.data.cache.impl

import android.content.Context
import technology.olala.data.entity.CityInfoEntity
import technology.olala.data.entity.CityListJson
import technology.olala.data.entity.mapper.CityInfoJsonMapper
import technology.olala.data.util.ParseUtils
import java.io.IOException
import javax.inject.Inject

/**
 * @author conghai on 8/26/18.
 */
class FileCached @Inject
internal constructor(private val context: Context) {
    fun loadCityInfoList() : List<CityInfoEntity> {
        val cityListJson = ParseUtils.gson.fromJson(loadJsonFromAsset(), CityListJson::class.java)
        return CityInfoJsonMapper().map(cityListJson.cityList)
    }

    private fun loadJsonFromAsset(): String? {
        try {
            val inputStream = context.assets.open("city.json")
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