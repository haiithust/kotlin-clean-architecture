package technology.olala.presentation.di.component


import dagger.Component
import technology.olala.presentation.di.module.CachedModule
import technology.olala.presentation.di.module.UserModule
import technology.olala.presentation.di.scope.UserScope
import technology.olala.presentation.ui.city.CityPresenter
import technology.olala.presentation.ui.home.ContactPresenter

/**
 * @author conghai on 7/17/18.
 */
@UserScope
@Component(dependencies = [ApplicationComponent::class], modules = [UserModule::class, CachedModule::class])
interface UserComponent {
    fun inject(presenter: ContactPresenter?)
    fun inject(presenter: CityPresenter?)
}
