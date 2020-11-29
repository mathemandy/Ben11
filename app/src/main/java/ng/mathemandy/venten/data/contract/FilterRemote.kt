package ng.mathemandy.venten.data.contract

import ng.mathemandy.venten.data.model.BaseRates


interface  FilterRemote {
    suspend fun  fetchBaseRates(): BaseRates
}