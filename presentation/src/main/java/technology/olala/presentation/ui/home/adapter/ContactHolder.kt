package technology.olala.presentation.ui.home.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.View
import android.widget.TextView

import technology.olala.baseproject.R
import technology.olala.presentation.model.ContactModel

/**
 * @author conghai on 7/24/18.
 */
class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val mTvName: TextView = itemView.findViewById(R.id.tv_name)
    private val mTvPhoneNumber: TextView = itemView.findViewById(R.id.tv_phone)
    private val mTvFirstCharacter: TextView = itemView.findViewById(R.id.tv_first_character)

    fun bindData(model: ContactModel?) {
        if (model != null) {
            val name = model.name
            if (!TextUtils.isEmpty(name)) {
                mTvFirstCharacter.text = name[0].toString()
            }
            mTvName.text = model.name
            mTvPhoneNumber.text = model.phoneNumber
        }
    }
}
