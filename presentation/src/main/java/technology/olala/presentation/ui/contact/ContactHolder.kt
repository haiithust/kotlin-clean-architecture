package technology.olala.presentation.ui.contact

import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import technology.olala.baseproject.R
import technology.olala.presentation.model.ContactModel

/**
 * @author conghai on 7/24/18.
 */
class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvName: TextView = itemView.findViewById(R.id.tv_name)
    private val tvPhoneNumber: TextView = itemView.findViewById(R.id.tv_phone)
    private val tvFirstCharacter: TextView = itemView.findViewById(R.id.tv_first_character)

    fun bindData(model: ContactModel?) {
        if (model != null) {
            val name = model.name
            if (!TextUtils.isEmpty(name)) {
                tvFirstCharacter.text = name[0].toString()
            }
            tvName.text = model.name
            tvPhoneNumber.text = model.phoneNumber
        }
    }
}
