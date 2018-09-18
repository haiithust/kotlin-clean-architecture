package technology.olala.data.response

import technology.olala.domain.constant.LocalConst
import technology.olala.domain.response.ErrorResponse

/**
 * @author conghai on 7/9/18.
 */
class CloudErrorResponse : ErrorResponse {
    override var errorCode: String = ""
    override var errorMessage = LocalConst.MESSAGE.UNKNOWN_ERROR

    constructor(errorCode: String) {
        this.errorCode = errorCode
    }

    constructor(errorCode: String, errorMessage: String) {
        this.errorCode = errorCode
        this.errorMessage = errorMessage
    }
}
