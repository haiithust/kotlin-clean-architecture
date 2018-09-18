package technology.olala.data.cache.impl

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject

/**
 * @author conghai on 7/7/18.
 */
class SharePreferenceCached @Inject
internal constructor(context: Context) {

    private val mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    companion object {
        private const val SHARED_PREFERENCE_NAME = "base_shared_preference"
    }
}
