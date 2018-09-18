package technology.olala.presentation.ui.base

/**
 * @author conghai on 7/7/18.
 */
interface BaseCallback {
    fun showLoading()

    fun hideLoading()

    fun showEmpty()

    fun hideEmpty()

    fun showError(messageId: Int)

    fun showNoNetworkAvailable()
}
