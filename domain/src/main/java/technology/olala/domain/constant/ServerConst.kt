package technology.olala.domain.constant

/**
 * @author conghai on 7/9/18.
 */
interface ServerConst {
    interface RESPONSE_CODE {
        companion object {
            val RESULT_CODE_SUCCESS = "success"
            val ERROR_SERVER = "error_server"
        }
        // todo other response code
    }
}
