package technology.olala.data.entity.mapper

import technology.olala.data.entity.ContactEntity
import technology.olala.domain.model.Contact
import technology.olala.domain.model.mapper.Mapper

/**
 * @author conghai on 7/25/18.
 */
class ContactEntityMapper : Mapper<ContactEntity, Contact>() {
    override fun map(value: ContactEntity?): Contact? {
        return if (value != null) {
            Contact(value.userName, value.phoneNumber)
        } else null
    }

    override fun revertMap(value: Contact?): ContactEntity? {
        return if (value != null) {
            ContactEntity(value.contactName, value.phoneNumber)
        } else null
    }
}
