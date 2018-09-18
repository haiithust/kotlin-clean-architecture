package technology.olala.presentation.ui.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import technology.olala.baseproject.R
import technology.olala.presentation.model.ContactModel
import java.util.*

/**
 * @author conghai on 7/24/18.
 */
class ContactAdapter : RecyclerView.Adapter<ContactHolder>() {
    private val contactList = ArrayList<ContactModel>()

    fun loadData(data: List<ContactModel>?) {
        contactList.clear()
        if (data != null) {
            contactList.addAll(data)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact_info, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bindData(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}
