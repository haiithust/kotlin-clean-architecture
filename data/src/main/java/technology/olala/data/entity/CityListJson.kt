package technology.olala.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author conghai on 8/26/18.
 */
class CityListJson {
    @SerializedName("city_list")
    val cityList: List<CityInfoJson> = ArrayList()
}
