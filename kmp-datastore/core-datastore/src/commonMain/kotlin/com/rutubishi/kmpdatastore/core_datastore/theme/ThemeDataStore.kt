package com.rutubishi.kmpdatastore.core_datastore.theme

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

interface ThemePreference {
    suspend fun isInDarkMode(): Boolean
    suspend fun changeTheme(enabled: Boolean): Preferences
}

internal class ThemePreferenceImpl(
    private val dataStore: DataStore<Preferences>
): ThemePreference {

    private companion object {
        const val PREFERENCE_NAME = "ThemePreferences"
        const val IS_DARK_MODE = "prefsBoolean"
    }

    private val darkModeKey =
        booleanPreferencesKey("$PREFERENCE_NAME$IS_DARK_MODE")

    override suspend fun isInDarkMode(): Boolean =
        dataStore.data.map { preferences -> preferences[darkModeKey] ?: false }.first()

    override suspend fun changeTheme(enabled: Boolean): Preferences =
        dataStore.edit { preferences -> preferences[darkModeKey] = enabled }
}

