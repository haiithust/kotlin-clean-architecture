package technology.olala.presentation.ui.util

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import technology.olala.domain.interactor.CoroutineUseCase
import technology.olala.domain.response.Loading
import technology.olala.domain.response.Result
import technology.olala.presentation.ui.base.BaseViewModel

fun <X, Y> BaseViewModel.execute(useCase: CoroutineUseCase<X, Y>, params: X, result: MutableLiveData<Result<Y>>) {
    viewModelScope.launch(dispatcher.io) {
        result.postValue(Loading)
        val data = useCase.invoke(params)
        result.postValue(data)
    }
}