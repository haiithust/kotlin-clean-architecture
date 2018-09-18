package technology.olala.presentation

import android.app.Application
import android.content.Context

import technology.olala.presentation.di.component.ApplicationComponent
import technology.olala.presentation.di.component.DaggerApplicationComponent
import technology.olala.presentation.di.component.DaggerUserComponent
import technology.olala.presentation.di.component.UserComponent
import technology.olala.presentation.di.module.ApplicationModule

/**
 * @author conghai on 7/8/18.
 */
class BaseApplication : Application() {
    private lateinit var mApplicationComponent: ApplicationComponent
    lateinit var userComponent: UserComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        userComponent = DaggerUserComponent.builder()
                .applicationComponent(mApplicationComponent)
                .build()
    }

    override fun getApplicationContext(): Context? {
        return mApplicationComponent.applicationContext
    }

    companion object {
        lateinit var instance: BaseApplication
    }
}
