package technology.olala.presentation.ui.contact

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_contact.*
import technology.olala.baseproject.R
import technology.olala.presentation.ui.base.BaseFragment
import technology.olala.presentation.userComponent

/**
 * @author conghai on 7/24/18.
 */
private const val REQUEST_CONTACT_PERMISSION = 0x012

class ContactFragment : BaseFragment(R.layout.fragment_contact) {
    private val viewModel: ContactViewModel by viewModels { factory }

    private var adapter: ContactAdapter = ContactAdapter()

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CONTACT_PERMISSION) {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                loadContactList()
            }
        }
    }

    override fun inject() {
        userComponent().inject(this)
    }

    override fun initUI() {
        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ContactFragment.adapter
        }
    }

    override fun registerEvents() {
        tool_bar.setNavigationOnClickListener {
            activity?.finish()
        }
    }

    override fun observe() {
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            handleLoading(it)
        })

        viewModel.listContact.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun loadData() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            loadContactList()
        } else {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CONTACT_PERMISSION)
        }
    }

    fun loadContactList() {

    }
}
