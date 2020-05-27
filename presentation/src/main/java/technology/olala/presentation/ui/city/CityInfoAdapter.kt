package technology.olala.presentation.ui.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import technology.olala.baseproject.R
import technology.olala.presentation.model.CityInfoModel

/**
 * @author conghai on 8/26/18.
 */
class CityInfoAdapter(private val listener: View.OnClickListener) : ListAdapter<CityInfoModel, CityInfoHolder>(CityDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityInfoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city_info, parent, false)
        view.setOnClickListener(listener)
        return CityInfoHolder(view)
    }

    override fun onBindViewHolder(holder: CityInfoHolder, position: Int) = holder(getItem(position))

    operator fun get(pos: Int): CityInfoModel = getItem(pos)
}

class CityInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvCityName = itemView.findViewById<TextView>(R.id.tv_city_name)
    private val tvCountryCode = itemView.findViewById<TextView>(R.id.tv_country_code)

    operator fun invoke(model: CityInfoModel) {
        tvCityName.text = model.cityName
        tvCountryCode.text = model.contryCode
    }
}

class CityDiffCallback : DiffUtil.ItemCallback<CityInfoModel>() {
    override fun areItemsTheSame(oldItem: CityInfoModel, newItem: CityInfoModel): Boolean {
        return oldItem.cityId == newItem.cityId
    }

    override fun areContentsTheSame(oldItem: CityInfoModel, newItem: CityInfoModel): Boolean {
        return oldItem == newItem
    }

}