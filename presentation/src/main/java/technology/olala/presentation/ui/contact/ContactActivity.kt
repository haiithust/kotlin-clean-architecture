package technology.olala.presentation.ui.contact

import android.content.Context
import android.content.Intent
import androidx.fragment.app.commit
import technology.olala.presentation.model.CityInfoModel
import technology.olala.presentation.ui.base.BaseActivity

class ContactActivity : BaseActivity() {

    companion object {
        const val KEY_CITY_INFO = "city_info"

        fun navigate(context: Context, cityInfoModel: CityInfoModel) {
            val intent = Intent(context, ContactActivity::class.java).apply {
                putExtra(KEY_CITY_INFO, cityInfoModel)
            }
            context.startActivity(intent)
        }
    }

    override fun initFragment() {
        supportFragmentManager.commit {
            replace(android.R.id.content, ContactFragment().apply {
                arguments = intent!!.extras
            })
        }
    }
}
