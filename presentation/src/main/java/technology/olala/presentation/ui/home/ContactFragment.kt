package technology.olala.presentation.ui.home

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import technology.olala.baseproject.R
import technology.olala.presentation.BaseApplication
import technology.olala.presentation.model.CityInfoModel
import technology.olala.presentation.model.ContactModel
import technology.olala.presentation.ui.base.BaseFragment
import technology.olala.presentation.ui.home.adapter.ContactAdapter

/**
 * @author conghai on 7/24/18.
 */
class ContactFragment : BaseFragment<ContactPresenter>(), ContactCallback {
    private var mAdapter: ContactAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater.inflate(R.layout.activity_main, container, false)
        val mRecyclerView = fragmentView.findViewById<RecyclerView>(R.id.recycler_view)
        mAdapter = ContactAdapter()
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.adapter = mAdapter
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            loadContactList()
        }
    }

    fun loadContactList() {
        mPresenter?.loadContactList()
    }

    override fun loadContactSuccess(contactModels: List<ContactModel>) {
        mAdapter?.loadData(contactModels)
    }

    override fun createPresenter(): ContactPresenter? {
        mPresenter = ContactPresenter(this)
        BaseApplication.instance.userComponent.inject(mPresenter)
        return mPresenter
    }

    companion object {
        fun getInstance(cityInfo : CityInfoModel?) : ContactFragment {
            return ContactFragment().apply {
                val bundle = Bundle()
                bundle.putParcelable(ContactActivity.KEY_CITY_INFO, cityInfo)
                arguments = bundle
            }
        }
    }
}
