package technology.olala.presentation.ui.contact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.map
import technology.olala.domain.interactor.GetContactList
import technology.olala.domain.model.Contact
import technology.olala.domain.response.Loading
import technology.olala.domain.response.Result
import technology.olala.domain.response.Success
import technology.olala.presentation.model.ContactModel
import technology.olala.presentation.scheduler.CoroutinesDispatcherProvider
import technology.olala.presentation.ui.base.BaseViewModel
import technology.olala.presentation.ui.util.execute
import javax.inject.Inject

/**
 * @author conghai on 7/24/18.
 */
class ContactViewModel @Inject constructor(
        dispatcher: CoroutinesDispatcherProvider,
        getContactList: GetContactList
) : BaseViewModel(dispatcher) {
    private val contactResult = MutableLiveData<Result<List<Contact>>>()

    val isLoading = contactResult.map { it is Loading }
    val listContact = contactResult.map {
        if (it is Success) it.data.map { item -> ContactModel(item.contactName, item.phoneNumber) } else emptyList()
    }.distinctUntilChanged()

    init {
        execute(getContactList, Unit, contactResult)
    }
}
