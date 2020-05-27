package technology.olala.presentation.ui.base

import androidx.lifecycle.ViewModel
import technology.olala.presentation.scheduler.CoroutinesDispatcherProvider

/**
 * @author conghai on 5/26/20.
 */
abstract class BaseViewModel(val dispatcher: CoroutinesDispatcherProvider): ViewModel()