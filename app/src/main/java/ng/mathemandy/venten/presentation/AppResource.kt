package ng.mathemandy.venten.presentation

class AppResource <out D> constructor(
    val status: AppStatus,
    val message: String? = null,
    val data: D? = null,
    val field: String? = null
){
    companion object {
        @JvmStatic
        fun <D> success(
            data: D,
            message: String? = null
        ): AppResource<D> = AppResource(
            status = AppStatus.SUCCESS,
            data = data,
            message = message
        )

        @JvmStatic
        fun <D> failed(
            message: String?
        ): AppResource<D> = AppResource(
            status = AppStatus.FAILED,
            data = null,
            message = message
        )

        @JvmStatic
        fun <D> validationError(
            message: String? = null,
            field: String?
        ): AppResource<D> = AppResource(
            status = AppStatus.VALIDATION_FAILED,
            message = message,
            field = field
        )

        @JvmStatic
        fun <D> loading(): AppResource<D> = AppResource(
            status = AppStatus.LOADING,
            data = null,
            message = null
        )

        @JvmStatic
        fun <D> loadingMore(): AppResource<D> = AppResource(
            status = AppStatus.LOADING_MORE,
            data = null,
            message = null
        )

        @JvmStatic
        fun <D> empty(msg : String? = null): AppResource<D> = AppResource(
            status = AppStatus.EMPTY,
            data = null,
            message = msg
        )
    }

}

enum class AppStatus {
    LOADING, FAILED, SUCCESS, LOADING_MORE, VALIDATION_FAILED, EMPTY
}
