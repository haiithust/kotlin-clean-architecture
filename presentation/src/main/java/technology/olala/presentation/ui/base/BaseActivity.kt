package technology.olala.presentation.ui.base

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import technology.olala.presentation.ui.util.UIUtils
import technology.olala.presentation.ui.view.LoadingDialog

/**
 * @author conghai on 7/9/18.
 */
open class BaseActivity : AppCompatActivity(), BaseCallback {
    private var mLoadingDialog: LoadingDialog? = null
    private var mCompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        mCompositeDisposable.clear()
        mLoadingDialog = null
    }

    protected fun injectFragment(containerViewId: Int, fragment: Fragment?, tag : String = "") {
        val fragmentTransaction = this.fragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId, fragment, tag)
        fragmentTransaction.commit()
    }

    /*
    Handle base callback
     */
    override fun showLoading() {
        showLoading("", false)
    }

    override fun hideLoading() {
        mLoadingDialog?.close()
    }

    override fun showEmpty() {

    }

    override fun hideEmpty() {

    }

    override fun showError(messageId: Int) {
        UIUtils.showShortToast(this, messageId)
    }

    override fun showNoNetworkAvailable() {
        // todo waiting design
    }

    /*
    Support function
     */
    protected fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    private fun showLoading(msg: String, cancelable: Boolean) {
        if (isFinishing) return

        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog(this)
        } else {
            if (mLoadingDialog?.isShowing == true) {
                mLoadingDialog?.setMessage(msg)
                return
            }
        }

        mLoadingDialog?.setMessage(msg)
        mLoadingDialog?.setOperationCancelable(cancelable)
        mLoadingDialog?.show()
    }
}
