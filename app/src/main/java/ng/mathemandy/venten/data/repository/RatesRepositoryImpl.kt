package ng.mathemandy.venten.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ng.mathemandy.venten.data.contract.FilterRemote
import ng.mathemandy.venten.data.model.BaseRates
import ng.mathemandy.venten.domain.repository.FilterRepository

class RatesRepositoryImpl  (
    private val filterRemote  : FilterRemote
) : FilterRepository {

    override fun fetchBaseRates(): Flow<BaseRates> {
        return   flow {
            emit(filterRemote.fetchBaseRates())
        }
    }
}