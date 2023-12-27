package ru.foolstack.splash.impl.domain.usecase

import ru.foolstack.splash.api.domain.usecase.GetLocalUseCase
import java.util.Locale

class GetLocalUseCaseImpl: GetLocalUseCase {
    override fun getUseCase(): String {
        return if (Locale.getDefault().language == "ru") "RU" else "ENG"
    }
}