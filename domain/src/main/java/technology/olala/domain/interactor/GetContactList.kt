package technology.olala.domain.interactor

import io.reactivex.Observable
import technology.olala.domain.model.Contact
import technology.olala.domain.repository.ContactRepository
import technology.olala.domain.scheduler.ResultScheduler
import technology.olala.domain.scheduler.WorkScheduler
import javax.inject.Inject

/**
 * @author conghai on 7/24/18.
 */
class GetContactList @Inject
internal constructor(workScheduler: WorkScheduler, resultScheduler: ResultScheduler, private val mContactRepository: ContactRepository) : UseCase<List<Contact>, Any>(workScheduler, resultScheduler) {
    override fun buildUseCaseObservable(params: Any?): Observable<List<Contact>> {
        return mContactRepository.contactList
    }

}
