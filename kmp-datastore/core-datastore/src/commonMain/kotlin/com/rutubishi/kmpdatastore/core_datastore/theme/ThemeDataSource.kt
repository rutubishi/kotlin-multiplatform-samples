package com.rutubishi.kmpdatastore.core_datastore.theme

import DataStoreAppComponent.coreComponent
import com.rutubishi.kmpdatastore.core_definitions.data.ThemeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

val AppThemeDataSource = object : ThemeDataSource {
    override suspend fun changeTheme(boolean: Boolean): Flow<Boolean> = flow {
        emit(boolean)
        coreComponent.themePreference.changeTheme(boolean)
    }

    override suspend fun isInDarkMode(): Flow<Boolean> = flow {
        emit(coreComponent.themePreference.isInDarkMode())
    }

}