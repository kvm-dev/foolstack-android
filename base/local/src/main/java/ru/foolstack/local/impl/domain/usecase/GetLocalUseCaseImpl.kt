package ru.foolstack.local.impl.domain.usecase

import ru.foolstack.local.api.domain.usecase.GetLocalUseCase
import java.util.Locale

class GetLocalUseCaseImpl: GetLocalUseCase {
    override fun getUseCase(): String {
        return if (Locale.getDefault().language == "ru") "RU" else "ENG"
    }
}