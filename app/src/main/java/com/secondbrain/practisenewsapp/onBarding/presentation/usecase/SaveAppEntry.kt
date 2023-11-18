package com.secondbrain.practisenewsapp.onBarding.presentation.usecase

import com.secondbrain.practisenewsapp.core.LocalUserManager
import kotlinx.coroutines.flow.Flow


class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}

data class AppEntryUseCases(
    val saveEntry : SaveAppEntry,
    val readAppEntry: ReadAppEntry
)

