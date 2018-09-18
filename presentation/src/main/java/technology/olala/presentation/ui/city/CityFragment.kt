package technology.olala.presentation.ui.city

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import technology.olala.baseproject.R
import technology.olala.presentation.BaseApplication
import technology.olala.presentation.model.CityInfoModel
import technology.olala.presentation.ui.base.BaseFragment
import technology.olala.presentation.ui.city.adapter.CityInfoAdapter
import technology.olala.presentation.ui.home.ContactActivity

/**
 * @author conghai on 8/25/18.
 */
class CityFragment : BaseFragment<CityPresenter>(), CityCallback {
    private lateinit var mAdapter: CityInfoAdapter

    override fun createPresenter(): CityPresenter? {
        mPresenter = CityPresenter(this)
        BaseApplication.instance.userComponent.inject(mPresenter)
        return mPresenter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_city_info, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        mAdapter = CityInfoAdapter(View.OnClickListener {
            val position = recyclerView.getChildLayoutPosition(it)
            val cityInfo = mAdapter.getItem(position)
            if (cityInfo != null) {
                ContactActivity.navigate(activity, cityInfo)
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = mAdapter
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter?.getCityInfoList()
    }

    override fun getCityInfoListSuccess(cityInfoModelList: List<CityInfoModel>) {
        mAdapter.loadData(cityInfoModelList)
    }

    companion object {
        val instance: CityFragment by lazy { CityFragment() }
    }
}