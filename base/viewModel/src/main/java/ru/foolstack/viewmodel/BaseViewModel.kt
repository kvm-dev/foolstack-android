package ru.foolstack.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.foolstack.utils.R
import ru.foolstack.utils.exceptions.AppExceptions
import ru.foolstack.utils.notifications.Message
import ru.foolstack.utils.notifications.SnackBarData
import ru.foolstack.viewmodel.intents.SingleLiveIntent
import ru.foolstack.viewmodel.model.LogoutType
import ru.foolstack.viewmodel.model.ProgressState

abstract class BaseViewModel : ViewModel() {
    private val _progressState = MutableStateFlow(ProgressState.COMPLETED)
    val progressState: StateFlow<ProgressState> = _progressState.asStateFlow()
    private val _logoutTrigger = SingleLiveIntent<LogoutType>()
    private val _errorDialogTrigger = SingleLiveIntent<Unit>()
    private val _snackBarTrigger = SingleLiveIntent<SnackBarData?>()

    open val genericErrorHandler: CoroutineExceptionHandler
        get() = CoroutineExceptionHandler { _, throwable ->
            if (throwable is AppExceptions) {
                handleException(throwable)
            }
        }

    protected fun CoroutineScope.with(
        onError: (AppExceptions) -> Unit = {},
        block: suspend CoroutineScope.() -> Unit,
    ) = launch(genericErrorHandler) {
        withActionSuspending(
            block = block,
            onError = onError
        )
    }

    protected fun CoroutineScope.withProgress(
        onError: (AppExceptions) -> Boolean = { false },
        block: suspend CoroutineScope.() -> Unit,
    ) = launch(genericErrorHandler) { withProgressSuspending(onError, block) }

    private suspend fun <T> withProgressSuspending(
        onError: (AppExceptions) -> Boolean = { false },
        block: suspend CoroutineScope.() -> T,
    ): T? = withActionSuspending(
        block = block,
        onStart = { startProgress() },
        onComplete = { completeProgress() },
        onError = { error ->
            completeProgress()
            if (!onError(error)) {
                when (error) {
                    AppExceptions.NetworkException.InternalServerException,
                    AppExceptions.NetworkException.UnavailableServiceException -> showErrorDialog()

                    else -> {}
                }
            }
        },
    )

    private fun showErrorDialog() = _errorDialogTrigger.postValue(Unit)

    @Suppress("TooGenericExceptionCaught")
    private suspend fun <T> withActionSuspending(
        onStart: (() -> Unit)? = null,
        onError: (AppExceptions) -> Unit,
        onComplete: (() -> Unit)? = null,
        block: suspend CoroutineScope.() -> T,
    ): T? = coroutineScope {
        try {
            onStart?.invoke()
            block().also { onComplete?.invoke() }
        } catch (e: AppExceptions.LocalException) {
            Log.e(TAG, "${((e as? AppExceptions.LocalException.UnknownException)?.throwable ?: e)}")
            onError(e)
            throw e
        } catch (e: AppExceptions.NetworkException) {
            Log.e(TAG, "$e")
            onError(e)
            null
        } catch (e: Throwable) {
            Log.e(TAG, "$e")
            onComplete?.invoke()
            throw e
        }
    }

     protected fun startProgress() {
     _progressState.value = ProgressState.LOADING
}

    protected fun completeProgress(){
        _progressState.value = ProgressState.COMPLETED
    }

    protected open fun handleException(exception: AppExceptions, onRetry: (() -> Unit)? = null) {
        when (exception) {
            is AppExceptions.NetworkException -> when (exception) {
                is AppExceptions.NetworkException.UnprocessableEntityException -> {}
                else -> {}
            }
            is AppExceptions.LocalException -> when (exception) {
                AppExceptions.LocalException.NoInternetConnectionException,
                AppExceptions.LocalException.TimeoutException -> showSnackBar(
                    SnackBarData.Error(
                        Message.IntRes(R.string.message_error_connect_description)
                    )
                )
                is AppExceptions.LocalException.Unauthorized.UnauthorizedException -> logout()
                is AppExceptions.LocalException.UnknownException -> {}
                else -> {}
            }
        }
    }

    fun logout(type: LogoutType = LogoutType.SELF_CHANGE_CLIENT) = _logoutTrigger.postValue(type)


    fun showSnackBar(data: SnackBarData) = _snackBarTrigger.postValue(data)

    fun hideSnackBar() = _snackBarTrigger.postValue(null)

    companion object{
        val TAG = "ViewModel"
    }
}

fun <T> MutableLiveData<T>.readOnly(): LiveData<T> = this