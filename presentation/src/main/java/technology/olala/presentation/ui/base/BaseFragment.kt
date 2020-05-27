package technology.olala.presentation.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import technology.olala.presentation.ui.view.LoadingDialog
import javax.inject.Inject

/**
 * @author conghai on 7/9/18.
 */
abstract class BaseFragment(
        @LayoutRes layoutId: Int
) : Fragment(layoutId) {
    @Inject
    internal lateinit var factory: ViewModelProvider.Factory

    private val loadingDialog: LoadingDialog by lazy { LoadingDialog(requireContext()) }

    abstract fun initUI()


    abstract fun inject()

    protected open fun registerEvents() {}

    protected open fun observe() {}

    protected open fun loadData() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        registerEvents()
        observe()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
    }

    override fun onDestroyView() {
        hideLoading()
        super.onDestroyView()
    }

    protected fun handleLoading(isShow: Boolean) {
        if (isShow) showLoading() else hideLoading()
    }

    private fun showLoading() {
        loadingDialog.show()
    }

    private fun hideLoading() {
        loadingDialog.dismiss()
    }
}
