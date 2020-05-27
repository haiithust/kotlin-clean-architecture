package technology.olala.data.repository

import android.app.Application
import android.provider.ContactsContract
import technology.olala.domain.model.Contact
import technology.olala.domain.repository.ContactRepository
import technology.olala.domain.response.Error
import technology.olala.domain.response.Result
import technology.olala.domain.response.Success
import javax.inject.Inject

/**
 * @author conghai on 7/25/18.
 */
class ContactRepositoryImpl @Inject constructor(private val application: Application) : ContactRepository {
    override suspend fun getContactList(): Result<List<Contact>> {
        try {
            val contactEntities = mutableListOf<Contact>()
            val projection = arrayOf(ContactsContract.Contacts._ID, // Contract class constant for the _ID column name
                    ContactsContract.Contacts.DISPLAY_NAME, // Contract class constant for the word column name
                    ContactsContract.Contacts.HAS_PHONE_NUMBER)
            val cur = application.contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                    projection, null, null, null)

            if (cur != null && cur.count > 0) {
                while (cur.moveToNext()) {
                    val id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID))
                    val name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))

                    if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                        val pCur = application.contentResolver.query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                                arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER),
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                                arrayOf(id), null)
                        if (pCur != null) {
                            while (pCur.moveToNext()) {
                                val phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                                contactEntities.add(Contact(name, phoneNo))
                            }
                            pCur.close()
                        }
                    }
                }
                cur.close()
            }
            return Success(contactEntities)
        } catch (e: Exception) {
            return Error(e)
        }
    }
}
