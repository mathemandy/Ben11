package ng.mathemandy.venten.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import ng.mathemandy.venten.data.model.BaseRates
import ng.mathemandy.venten.data.model.Filter
import ng.mathemandy.venten.domain.usecase.FetchExchangeRates


class ExchangeRatesViewModel(val fetchExchangeRates: FetchExchangeRates) : ViewModel() {


    val mFetchFiltersLiveData = MutableLiveData<AppResource<List<Filter>>>(AppResource.empty())
    val mExchangeRatesData = MutableLiveData<AppResource<BaseRates>>(AppResource.empty())

    init {
        getFilters()
    }

    fun getFilters() = viewModelScope.launch {
        mFetchFiltersLiveData.postValue(AppResource.loading())
        val filter = fetchExchangeRates.execute()
        filter
            .handleErrors()
            .collect {
                processExchangeRates(it)
            }


    }


    fun processExchangeRates(filters: BaseRates) {

        if (filters.success) {
            mExchangeRatesData.postValue(AppResource.success(filters))
        } else {
            mExchangeRatesData.postValue(AppResource.empty())
        }


    }

    fun <T> Flow<T>.handleErrors(): Flow<T> = flow {
        try {
            collect { value -> emit(value) }
        } catch (e: Throwable) {
            mFetchFiltersLiveData.postValue(AppResource.failed(e.message))
        }
    }
}