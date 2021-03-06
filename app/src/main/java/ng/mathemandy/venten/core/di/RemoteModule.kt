package ng.mathemandy.venten.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import ng.mathemandy.venten.BuildConfig
import ng.mathemandy.venten.core.PostExecutionThreadImpl
import ng.mathemandy.venten.data.contract.FilterRemote
import ng.mathemandy.venten.domain.executor.PostExecutionThread
import ng.mathemandy.venten.domain.usecase.FetchExchangeRates
import ng.mathemandy.venten.presentation.ExchangeRatesViewModel
import ng.mathemandy.venten.presentation.ui.CarsViewModel
import ng.mathemandy.venten.remote.ApiServiceFactory
import ng.mathemandy.venten.remote.impl.FetchBaseRates
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val  remoteModule  = module {
    single<FilterRemote> { FetchBaseRates(get ())  }
    single  { Moshi.Builder().add(KotlinJsonAdapterFactory()).build()}
    single { ApiServiceFactory.makeApiService(BuildConfig.DEBUG, get())}
}

val coreModule =  module {
    single <PostExecutionThread> { PostExecutionThreadImpl() }
}


val viewModelModule  =  module  {
    viewModel { ExchangeRatesViewModel(get()) }
    viewModel { CarsViewModel(get()) }
}

val useCaseModule  = module {
    single { FetchExchangeRates(get(), get())  }
}

val appModule  = listOf(remoteModule, dataModule, coreModule, useCaseModule, viewModelModule)