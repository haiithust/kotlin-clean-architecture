package technology.olala.data.response

import com.google.gson.annotations.SerializedName

import technology.olala.domain.constant.ServerConst
import technology.olala.domain.response.SuccessResponse

/**
 * @author conghai on 7/9/18.
 */
abstract class CloudResponse<T> : SuccessResponse<T> {
    @SerializedName("result")
    val resultCode: String? = null

    val isSuccess: Boolean = resultCode == ServerConst.RESPONSE_CODE.RESULT_CODE_SUCCESS
}
