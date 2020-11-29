package ng.mathemandy.venten.remote.impl

import ng.mathemandy.venten.data.model.Filter
import ng.mathemandy.venten.remote.ApiService
import ng.mathemandy.venten.data.contract.FilterRemote
import ng.mathemandy.venten.data.model.BaseRates

class FetchBaseRates (val apiService: ApiService) : FilterRemote {
    override suspend fun fetchBaseRates(): BaseRates {
        return apiService.fetchBaseRates()
    }
}