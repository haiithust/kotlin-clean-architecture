package technology.olala.domain.repository

import io.reactivex.Observable
import technology.olala.domain.model.Contact

/**
 * @author conghai on 7/24/18.
 */
interface ContactRepository {
    val contactList: Observable<List<Contact>>
}
