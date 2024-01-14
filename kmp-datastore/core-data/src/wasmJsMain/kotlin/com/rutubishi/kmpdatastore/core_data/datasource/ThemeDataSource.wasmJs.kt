package com.rutubishi.kmpdatastore.core_data.datasource

import com.rutubishi.kmpdatastore.core_definitions.data.ThemeDataSource
import kotlinx.browser.localStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

actual fun buildThemeDataSource(): ThemeDataSource {
    return object : ThemeDataSource {

        private val THEME_KEY = "isDarkTheme"

        override suspend fun changeTheme(boolean: Boolean): Flow<Boolean> = flow {
            localStorage.setItem(THEME_KEY, boolean.toString())
            emit(boolean)
        }

        override suspend fun isInDarkMode(): Flow<Boolean> = flow {
            emit(localStorage.getItem(THEME_KEY)?.toBooleanStrictOrNull() ?: true )
        }

    }
}