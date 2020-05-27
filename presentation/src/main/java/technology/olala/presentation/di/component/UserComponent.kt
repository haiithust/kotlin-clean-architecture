package technology.olala.presentation.di.component


import dagger.Component
import technology.olala.presentation.di.module.UserModule
import technology.olala.presentation.di.module.ViewModelModule
import technology.olala.presentation.di.scope.UserScope
import technology.olala.presentation.ui.city.CityFragment
import technology.olala.presentation.ui.contact.ContactFragment

/**
 * @author conghai on 7/17/18.
 */
@UserScope
@Component(dependencies = [ApplicationComponent::class], modules = [UserModule::class, ViewModelModule::class])
interface UserComponent {
    fun inject(fragment: CityFragment)

    fun inject(fragment: ContactFragment)
}
