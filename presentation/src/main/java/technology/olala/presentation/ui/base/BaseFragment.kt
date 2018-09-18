/**
 * Copyright (C) 2014 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package technology.olala.presentation.ui.base

import android.app.Fragment
import android.os.Bundle

import technology.olala.presentation.ui.util.UIUtils
import technology.olala.presentation.ui.view.LoadingDialog

/**
 * @author conghai on 7/9/18.
 */
abstract class BaseFragment<V : BasePresenter<*>> : Fragment(), BaseCallback {
    protected var mPresenter: V? = null
    private var mLoadingDialog: LoadingDialog? = null

    init {
        retainInstance = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()
        mPresenter?.create()
    }

    protected abstract fun createPresenter(): V?

    override fun onStart() {
        super.onStart()
        mPresenter?.start()
    }

    override fun onPause() {
        super.onPause()
        mPresenter?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.destroy()
        mLoadingDialog = null
    }

    // todo implement
    override fun showLoading() {
        showLoading("", false)
    }

    override fun hideLoading() {
        mLoadingDialog?.close()
    }

    override fun showEmpty() {
        // todo waiting design
    }

    override fun hideEmpty() {
        // todo waiting design
    }

    override fun showError(messageId: Int) {
        UIUtils.showShortToast(activity, messageId)
    }

    override fun showNoNetworkAvailable() {
        // todo waiting design
    }

    private fun showLoading(msg: String, cancelable: Boolean) {
        if (activity == null || activity.isFinishing) return

        if (mLoadingDialog == null) {
            mLoadingDialog = LoadingDialog(activity)
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
