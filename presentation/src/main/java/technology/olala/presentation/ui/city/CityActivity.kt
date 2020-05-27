package technology.olala.presentation.ui.city

import androidx.fragment.app.commit
import technology.olala.presentation.ui.base.BaseActivity

/**
 * @author conghai on 8/25/18.
 */
class CityActivity : BaseActivity() {

    override fun initFragment() {
        supportFragmentManager.commit {
            replace(android.R.id.content, CityFragment())
        }
    }
}