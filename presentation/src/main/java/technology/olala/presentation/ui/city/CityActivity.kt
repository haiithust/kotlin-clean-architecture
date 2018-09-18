package technology.olala.presentation.ui.city

import android.os.Bundle
import technology.olala.baseproject.R
import technology.olala.presentation.ui.base.BaseActivity

/**
 * @author conghai on 8/25/18.
 */
class CityActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contain_fragment)

        if (savedInstanceState == null) {
            injectFragment(R.id.fragmentContainer, CityFragment.instance)
        }
    }
}