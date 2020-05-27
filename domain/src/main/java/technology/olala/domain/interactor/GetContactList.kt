package technology.olala.domain.interactor

import technology.olala.domain.model.Contact
import technology.olala.domain.response.Result
import technology.olala.domain.repository.ContactRepository
import javax.inject.Inject

/**
 * @author conghai on 7/24/18.
 */
class GetContactList @Inject
constructor(private val repository: ContactRepository) : CoroutineUseCase<Unit, List<Contact>>() {
    override suspend fun invoke(params: Unit): Result<List<Contact>> {
        return repository.getContactList()
    }
}
