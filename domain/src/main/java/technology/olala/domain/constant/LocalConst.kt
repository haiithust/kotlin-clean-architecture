package technology.olala.domain.constant

/**
 * @author conghai on 7/9/18.
 */
interface LocalConst {
    interface MESSAGE {
        companion object {
            val UNKNOWN_ERROR = "Unknow error"
        }
    }

    interface ERROR {
        companion object {
            val NO_NETWORK_CONNECTION = "error_network"
        }
    }
}
