package technology.olala.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author conghai on 8/25/18.
 */
@Parcelize
data class CityInfoModel(val cityId: Int,val cityName: String,val contryCode: String,val latitude: Double,val longitude: Double) : Parcelable