package com.rutubishi.kmpdatastore.core_data.repository

import com.rutubishi.kmpdatastore.core_definitions.data.ThemeDataSource

class ThemeRepository(
    private val themeDataSource: ThemeDataSource
) {
    suspend fun isInDarkMode() = themeDataSource.isInDarkMode()
    suspend fun changeTheme(darkMode: Boolean) = themeDataSource.changeTheme(darkMode)

}