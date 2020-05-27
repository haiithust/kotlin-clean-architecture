package technology.olala.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import technology.olala.presentation.ui.base.BaseActivity
import technology.olala.presentation.ui.city.CityActivity

/**
 * @author conghai on 7/24/18.
 */
class SplashActivity : BaseActivity() {
    private val handler: Handler by lazy { Handler() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        handler.postDelayed({
            startActivity(Intent(this, CityActivity::class.java))
            overridePendingTransition(0, 0)
        }, 1000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }
}
