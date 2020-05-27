package technology.olala.presentation.scheduler

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provide coroutines context.
 */
@Singleton
data class CoroutinesDispatcherProvider(
        val main: CoroutineDispatcher,
        val computation: CoroutineDispatcher,
        val io: CoroutineDispatcher
) {
    @Inject
    constructor() : this(Main, Default, IO)
}
