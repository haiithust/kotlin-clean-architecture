package technology.olala.presentation.ui.home

import javax.inject.Inject

import technology.olala.domain.interactor.BaseObserver
import technology.olala.domain.interactor.GetContactList
import technology.olala.domain.model.Contact
import technology.olala.presentation.model.mapper.ContactModelMapper
import technology.olala.presentation.ui.base.BasePresenter

/**
 * @author conghai on 7/24/18.
 */
class ContactPresenter(callback: ContactCallback) : BasePresenter<ContactCallback>(callback) {
    @Inject
    lateinit var getContactList: GetContactList

    fun loadContactList() {
        executeTask(getContactList, Any(), object : BaseObserver<List<Contact>>() {
            override fun onSubscriber() {
                super.onSubscriber()
                callback?.showLoading()
            }

            override fun onHandleSuccess(t: List<Contact>) {
                super.onHandleSuccess(t)
                callback?.loadContactSuccess(ContactModelMapper().map(t))
            }

            override fun onBeforeEnd(isSuccess: Boolean) {
                super.onBeforeEnd(isSuccess)
                callback?.hideLoading()
            }
        })
    }
}
