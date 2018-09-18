package technology.olala.data.util

import com.google.gson.Gson

/**
 * @author conghai on 8/26/18.
 */
class ParseUtils {
    companion object {
        val gson : Gson by lazy { Gson() }
    }
}