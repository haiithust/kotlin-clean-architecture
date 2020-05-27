package technology.olala.presentation.ui.city

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_city_info.*
import technology.olala.baseproject.R
import technology.olala.presentation.ui.base.BaseFragment
import technology.olala.presentation.ui.contact.ContactActivity
import technology.olala.presentation.userComponent


/**
 * @author conghai on 8/25/18.
 */
class CityFragment : BaseFragment(R.layout.fragment_city_info) {
    private val viewModel: CityViewModel by viewModels { factory }

    private val onRecyclerItemClicked = View.OnClickListener {
        val position = recycler_view.getChildLayoutPosition(it)
        ContactActivity.navigate(requireActivity(), adapter[position])
    }

    private val adapter: CityInfoAdapter = CityInfoAdapter(onRecyclerItemClicked)

    override fun initUI() {
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = adapter
    }

    override fun inject() {
        userComponent().inject(this)
    }

    override fun observe() {
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            handleLoading(it)
        })
        viewModel.cityList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}