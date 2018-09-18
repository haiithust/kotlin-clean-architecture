package technology.olala.presentation.ui.home

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v4.content.ContextCompat
import technology.olala.baseproject.R
import technology.olala.presentation.model.CityInfoModel
import technology.olala.presentation.ui.base.BaseActivity

class ContactActivity : BaseActivity() {

    companion object {
        const val KEY_CITY_INFO = "city_info"
        private const val REQUEST_CONTACT_PERMISSION = 0x012

        fun navigate(context: Context?, cityInfoModel: CityInfoModel) {
            val intent = Intent(context, ContactActivity::class.java)
            intent.apply {
                putExtra(KEY_CITY_INFO, cityInfoModel)
            }
            context?.startActivity(intent)
        }
    }

    private var contactFragment: ContactFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contain_fragment)

        val cityInfo = intent?.getParcelableExtra(KEY_CITY_INFO) as? CityInfoModel?
        supportActionBar?.title = cityInfo?.cityName

        if (savedInstanceState == null) {
            contactFragment = ContactFragment.getInstance(intent?.getParcelableExtra(KEY_CITY_INFO))
            injectFragment(R.id.fragmentContainer, contactFragment, "ContactFragment")
        } else {
            contactFragment = fragmentManager.findFragmentByTag("ContactFragment") as? ContactFragment
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CONTACT_PERMISSION)
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CONTACT_PERMISSION) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                contactFragment?.loadContactList()
            }
        }
    }
}
