package com.rutubishi.kmpdatastore.core_data.datasource

import com.rutubishi.kmpdatastore.core_datastore.theme.AppThemeDataSource
import com.rutubishi.kmpdatastore.core_definitions.data.ThemeDataSource

actual fun buildThemeDataSource(): ThemeDataSource {
    return AppThemeDataSource
}