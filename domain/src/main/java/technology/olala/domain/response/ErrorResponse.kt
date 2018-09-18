package technology.olala.domain.response

abstract class ErrorResponse : Throwable() {
    abstract val errorCode: String?
    abstract val errorMessage: String?
}
