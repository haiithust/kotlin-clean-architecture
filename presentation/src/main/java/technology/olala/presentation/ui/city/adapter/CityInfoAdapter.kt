package technology.olala.presentation.ui.city.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import technology.olala.baseproject.R
import technology.olala.presentation.model.CityInfoModel

/**
 * @author conghai on 8/26/18.
 */
class CityInfoAdapter(private val mOnClickListener : View.OnClickListener) : RecyclerView.Adapter<CityInfoHolder>() {
    private var mCityInfoList: ArrayList<CityInfoModel> = ArrayList()

    fun loadData(cityInfoList : List<CityInfoModel>?) {
        mCityInfoList.clear()
        if (cityInfoList != null) {
            mCityInfoList.addAll(cityInfoList)
        }

        notifyDataSetChanged()
    }

    fun getItem(position: Int) : CityInfoModel? {
        if (position >=0 && position < mCityInfoList.size) {
            return mCityInfoList[position]
        }
        return null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityInfoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city_info, parent, false)
        view.setOnClickListener(mOnClickListener)
        return CityInfoHolder(view)
    }

    override fun onBindViewHolder(holder: CityInfoHolder, position: Int) {
        holder.bindData(mCityInfoList[position])
    }

    override fun getItemCount(): Int {
        return mCityInfoList.size
    }
}