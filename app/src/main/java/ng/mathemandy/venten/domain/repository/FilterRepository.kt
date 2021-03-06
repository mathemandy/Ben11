package ng.mathemandy.venten.domain.repository

import kotlinx.coroutines.flow.Flow
import ng.mathemandy.venten.data.model.BaseRates
import ng.mathemandy.venten.data.model.Filter


interface  FilterRepository {

    fun fetchBaseRates() : Flow<BaseRates>
}