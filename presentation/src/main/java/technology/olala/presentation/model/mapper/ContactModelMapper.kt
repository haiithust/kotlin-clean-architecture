package technology.olala.presentation.model.mapper

import technology.olala.domain.model.Contact
import technology.olala.domain.model.mapper.Mapper
import technology.olala.presentation.model.ContactModel

/**
 * @author conghai on 7/25/18.
 */
class ContactModelMapper : Mapper<Contact, ContactModel>() {
    override fun revertMap(value: ContactModel?): Contact? {
        return if (value != null) {
            Contact(value.name, value.phoneNumber)
        } else null
    }

    override fun map(value: Contact?): ContactModel? {
        return if (value != null) {
            ContactModel(value.contactName, value.phoneNumber)
        } else null
    }
}
