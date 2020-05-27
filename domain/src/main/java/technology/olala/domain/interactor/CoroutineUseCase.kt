package technology.olala.domain.interactor

import technology.olala.domain.response.Result

/**
 * @author conghai on 7/7/18.
 */
abstract class CoroutineUseCase<in P, out T> {
    abstract suspend operator fun invoke(params: P): Result<T>
}
