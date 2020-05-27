package technology.olala.data.entity

import com.google.gson.annotations.SerializedName

/**
 * @author conghai on 8/26/18.
 */
class CityInfoJson {
    @SerializedName("id")
    val cityId: Long = 0L

    @SerializedName("name")
    val cityName: String? = null

    @SerializedName("country")
    val countryCode: String? = null

    @SerializedName("coord")
    private val coordinate: Coordinate? = null

    val latitude: Double
        get() = coordinate?.latitude ?: 0.0

    val longitude: Double
        get() = coordinate?.longitude ?: 0.0
}

private class Coordinate(
        @SerializedName("lon")
        val longitude: Double,
        @SerializedName("lat")
        val latitude: Double
)
