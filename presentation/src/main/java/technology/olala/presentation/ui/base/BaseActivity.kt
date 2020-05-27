package technology.olala.presentation.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import technology.olala.presentation.ui.view.LoadingDialog

/**
 * @author conghai on 7/9/18.
 */
abstract class BaseActivity : AppCompatActivity() {
    private val loadingDialog: LoadingDialog by lazy { LoadingDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            initFragment()
        }
        observe()
    }

    protected open fun observe() {}

    private fun showLoading() {
        loadingDialog.show()
    }

    private fun hideLoading() {
        loadingDialog.dismiss()
    }

    protected open fun initFragment() {}
}
