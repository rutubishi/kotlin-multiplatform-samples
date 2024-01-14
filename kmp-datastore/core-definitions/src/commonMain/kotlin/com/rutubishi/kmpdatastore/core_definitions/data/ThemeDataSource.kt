package com.rutubishi.kmpdatastore.core_definitions.data

import kotlinx.coroutines.flow.Flow

interface ThemeDataSource {
    suspend fun changeTheme(boolean: Boolean): Flow<Boolean>
    suspend fun isInDarkMode(): Flow<Boolean>

}