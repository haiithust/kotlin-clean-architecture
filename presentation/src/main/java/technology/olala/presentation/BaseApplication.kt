package technology.olala.presentation

import android.app.Application
import androidx.fragment.app.Fragment
import technology.olala.presentation.di.component.ApplicationComponent
import technology.olala.presentation.di.component.DaggerApplicationComponent
import technology.olala.presentation.di.component.DaggerUserComponent
import technology.olala.presentation.di.component.UserComponent

/**
 * @author conghai on 7/8/18.
 */
class BaseApplication : Application() {
    private val mApplicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
    }
    val userComponent: UserComponent by lazy {
        DaggerUserComponent.builder()
                .applicationComponent(mApplicationComponent)
                .build()
    }
}

fun Fragment.userComponent() = (requireActivity().application as BaseApplication).userComponent
