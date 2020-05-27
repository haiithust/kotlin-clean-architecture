package technology.olala.presentation.ui.contact

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import technology.olala.baseproject.R
import technology.olala.presentation.model.ContactModel

/**
 * @author conghai on 7/24/18.
 */
class ContactAdapter : ListAdapter<ContactModel, ContactHolder>(ContactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact_info, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}

class ContactDiffCallback : DiffUtil.ItemCallback<ContactModel>() {
    override fun areItemsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ContactModel, newItem: ContactModel): Boolean {
        return oldItem == newItem
    }
}
