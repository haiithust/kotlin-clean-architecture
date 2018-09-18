package technology.olala.presentation.response

import technology.olala.baseproject.R
import technology.olala.domain.constant.ServerConst
import technology.olala.domain.response.ErrorResponse

/**
 * @author conghai on 7/19/18.
 */
object ResponseMessageFactory {
    fun getResStringByResponse(error: ErrorResponse): Int {
        var messageId = R.string.ex_error_unknown

        if (error.errorMessage == ServerConst.RESPONSE_CODE.ERROR_SERVER) {
            messageId = R.string.ex_error_server
        }

        return messageId
    }
}
