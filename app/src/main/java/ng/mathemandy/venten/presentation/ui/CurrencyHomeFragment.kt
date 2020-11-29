package ng.mathemandy.venten.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ng.mathemandy.venten.R
import ng.mathemandy.venten.presentation.AppStatus
import ng.mathemandy.venten.presentation.ExchangeRatesViewModel
import org.koin.android.ext.android.inject

class CurrencyHomeFragment : BaseFragment() {
    private val exchangeRatesViewModel: ExchangeRatesViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_currency_home, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initDataListener()

    }

    private fun initDataListener() {
        exchangeRatesViewModel.mExchangeRatesData.observe(viewLifecycleOwner, {
            when (it.status) {
                AppStatus.LOADING -> {
                    Toast.makeText(context, "loading", Toast.LENGTH_SHORT).show()
//                    renderLoadingState()
                }
                AppStatus.SUCCESS -> {
                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show()
//
//                    it.data?.let { it1 -> adapter.swapData(it1, null) }
//                    renderSuccessState()
                }

                AppStatus.FAILED -> {
                    Toast.makeText(context, "failed - ${it.message}", Toast.LENGTH_SHORT).show()
//

//                    if (adapter.itemCount > 0){
//                        it.message?.let { it1 ->  renderDataAvailableErrorState(it1) }
//
//                    }else {
//                        it.message?.let { it1 -> renderNoDataErrorState(it1) }
//
//                    }


                }

                AppStatus.EMPTY -> {
                    Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show()
//

//                    renderEmptyState()
                }
            }

        })


    }


}