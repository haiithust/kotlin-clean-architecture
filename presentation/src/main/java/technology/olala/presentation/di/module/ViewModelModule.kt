package technology.olala.presentation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import technology.olala.presentation.di.scope.UserScope
import technology.olala.presentation.ui.city.CityViewModel
import technology.olala.presentation.ui.contact.ContactViewModel
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

/**
 * @author conghai on 5/14/20.
 */
class ViewModelFactory @Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = viewModels[modelClass]!!.get() as T
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {

    @Binds
    @UserScope
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CityViewModel::class)
    abstract fun bindCityViewModel(viewModel: CityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ContactViewModel::class)
    abstract fun bindContactViewModel(viewModel: ContactViewModel): ViewModel
    //Add more ViewModels here
}