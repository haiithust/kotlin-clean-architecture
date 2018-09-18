package technology.olala.presentation.ui.home

import technology.olala.presentation.model.ContactModel
import technology.olala.presentation.ui.base.BaseCallback

/**
 * @author conghai on 7/24/18.
 */
interface ContactCallback : BaseCallback {
    fun loadContactSuccess(contactModels: List<ContactModel>)
}
