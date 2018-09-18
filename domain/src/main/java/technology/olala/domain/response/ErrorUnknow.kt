package technology.olala.domain.response

/**
 * @author conghai on 9/18/18.
 */
class ErrorUnknow(private val throwable: Throwable?) : ErrorResponse() {
    override val errorCode: String?
        get() = throwable?.message ?: ""
    override val errorMessage: String
        get() = throwable?.message ?: ""

}