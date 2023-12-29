package ru.foolstack.splash.viewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.foolstack.splash.interactor.SplashInteractor
import ru.foolstack.splash.ui.ViewState
import ru.foolstack.viewmodel.BaseViewModel

class SplashViewModel(private val interactor: SplashInteractor): BaseViewModel() {
    private val _connectionState = MutableStateFlow(ViewState.ConnectionState.DISCONNECTED)
    val connectionState = _connectionState.asStateFlow()
    fun superTest() = 25
    fun getLocal() = interactor.getLocal()

    fun checkConnection() =  with(viewModelScope){
            launch(Dispatchers.IO){ getNetworkStatus() }
        }

    private suspend fun getNetworkStatus() {
        val connection = interactor.getNetworkStatus()
        if(connection){
            _connectionState.emit(ViewState.ConnectionState.CONNECTED)
        }
        else{
            _connectionState.emit(ViewState.ConnectionState.DISCONNECTED)
        }
        while(!connection){
            delay(5000L)
            val result = interactor.getNetworkStatus()
            if(result){
                _connectionState.emit(ViewState.ConnectionState.CONNECTED)
            }
            else{
                _connectionState.emit(ViewState.ConnectionState.DISCONNECTED)
            }

        }
    }
}