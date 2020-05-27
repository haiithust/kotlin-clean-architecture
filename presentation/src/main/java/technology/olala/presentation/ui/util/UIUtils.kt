package technology.olala.presentation.ui.util

import android.content.Context
import androidx.annotation.StringRes
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**
 * @author conghai on 7/19/18.
 */
object UIUtils {
    fun showShortToast(context: Context, msg: CharSequence?) {
        if (msg == null || msg.isEmpty()) return
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showShortToast(context: Context, @StringRes msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showLongToast(context: Context, msg: CharSequence?) {
        if (msg == null || msg.isEmpty()) return
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun showLongToast(context: Context, @StringRes msg: Int) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    fun hideKeyboard(v: View?) {
        v ?: return

        val context = v.context ?: return

        val token = v.windowToken ?: return

        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(token, InputMethodManager.RESULT_UNCHANGED_SHOWN)
    }

    fun showKeyboard(v: View?) {
        if (v == null) return

        val context = v.context ?: return

        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(v, 0)
    }
}
