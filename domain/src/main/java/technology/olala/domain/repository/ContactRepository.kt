package technology.olala.domain.repository

import technology.olala.domain.model.Contact
import technology.olala.domain.response.Result

/**
 * @author conghai on 7/24/18.
 */
interface ContactRepository {
    suspend fun getContactList(): Result<List<Contact>>
}
