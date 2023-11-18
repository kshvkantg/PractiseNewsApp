package com.secondbrain.practisenewsapp.core

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.secondbrain.practisenewsapp.utils.Constants.IS_FIRST_TIME_ENTRY
import com.secondbrain.practisenewsapp.utils.Constants.PREFERENCE_STORE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


interface LocalUserManager {

    // to write in preference DataStore - if user is opening for first time
    suspend fun saveAppEntry()

    // to get the same status in order to define
    // that if onboarding screen should be shown or not
    fun readAppEntry() : Flow<Boolean>

}

class LocalUserManagerImplementation (
    private val context : Context
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit {entryLog ->
            entryLog[PreferenceKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.APP_ENTRY] ?: false
        }
    }

}

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_STORE)

private object PreferenceKeys {
    val APP_ENTRY = booleanPreferencesKey(IS_FIRST_TIME_ENTRY)
}


