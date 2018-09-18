package technology.olala.presentation.ui.city.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import technology.olala.baseproject.R
import technology.olala.presentation.model.CityInfoModel

/**
 * @author conghai on 8/26/18.
 */
class CityInfoHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
    private val mTvCityName = itemView.findViewById<TextView>(R.id.tv_city_name)
    private val mTvCountryCode = itemView.findViewById<TextView>(R.id.tv_country_code)

    public fun bindData(cityInfoModel: CityInfoModel?) {
        mTvCityName.text = cityInfoModel?.cityName
        mTvCountryCode.text = cityInfoModel?.contryCode
    }
}