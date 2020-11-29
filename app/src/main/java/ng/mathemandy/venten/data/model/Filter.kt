package ng.mathemandy.venten.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Filter(
    val id: Int,
    val start_year: Int,
    val end_year: Int,
    val gender: String,
    val countries: List<String>,
    val colors: List<String>

) : Parcelable

@Parcelize
data class BaseRates(
    val success: Boolean,
    val timestamp: Int,
    val base: String,
    val date: String,
    val rates: Map<String?, Double?>
) : Parcelable


