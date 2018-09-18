package technology.olala.domain.response

import technology.olala.domain.constant.LocalConst

/**
 * @author conghai on 7/20/18.
 */
class ErrorNetworkResponse : ErrorResponse() {
    override val errorCode: String = LocalConst.ERROR.NO_NETWORK_CONNECTION

    override val errorMessage: String = ""
}
