package technology.olala.domain.response

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T> {
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

data class Success<out T>(val data: T) : Result<T>()
data class Error(val exception: Exception) : Result<Nothing>()
object Loading : Result<Nothing>()