package ru.local.utils.notifications

import androidx.annotation.StringRes

interface Message {

    class String(
        val message: kotlin.String
    ) : Message

    class IntRes(
        @StringRes val message: Int
    ) : Message

}

sealed class SnackBarData {

    class Error(val info: Message?) : SnackBarData()

    class Push(
        val title: Message?,
        val description: Message?,
        val action: () -> Unit
    ) : SnackBarData()

}