package technology.olala.data.repository

import android.content.Context
import android.provider.ContactsContract
import io.reactivex.Observable
import technology.olala.data.entity.ContactEntity
import technology.olala.data.entity.mapper.ContactEntityMapper
import technology.olala.domain.model.Contact
import technology.olala.domain.repository.ContactRepository
import java.util.*

/**
 * @author conghai on 7/25/18.
 */
class ContactRepositoryImpl(private val mContext: Context) : ContactRepository {
    override val contactList: Observable<List<Contact>>
        get() = Observable.fromCallable<ArrayList<ContactEntity>> { this.loadContactListFromDevice() }
                .map { contactEntities -> ContactEntityMapper().map(contactEntities) }

    private fun loadContactListFromDevice(): ArrayList<ContactEntity> {
        val contactEntities = ArrayList<ContactEntity>()
        val contentResolver = mContext.contentResolver
        val projection = arrayOf(ContactsContract.Contacts._ID, // Contract class constant for the _ID column name
                ContactsContract.Contacts.DISPLAY_NAME, // Contract class constant for the word column name
                ContactsContract.Contacts.HAS_PHONE_NUMBER)
        val cur = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                projection, null, null, null)

        if (cur != null && cur.count > 0) {
            while (cur.moveToNext()) {
                val id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID))
                val name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))

                if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    val pCur = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER),
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            arrayOf(id), null)
                    if (pCur != null) {
                        while (pCur.moveToNext()) {
                            val phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            contactEntities.add(ContactEntity(name, phoneNo))
                        }
                        pCur.close()
                    }
                }
            }
        }
        cur?.close()
        return contactEntities
    }
}
