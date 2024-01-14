package com.rutubishi.kmpdatastore.core_datastore.app

import android.content.Context
import androidx.datastore.core.DataMigration
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.CoroutineScope
import java.io.File

actual fun dataStorePreferences(
    corruptionHandler: ReplaceFileCorruptionHandler<Preferences>?,
    coroutineScope: CoroutineScope,
    migrations: List<DataMigration<Preferences>>,
    context: Any?,
): DataStore<Preferences>  = createDataStoreWithDefaults(
    corruptionHandler = corruptionHandler,
    coroutineScope = coroutineScope,
    migrations = migrations,
    path = { mCtx ->
        if(mCtx == null)
            throw IllegalStateException("You must provide context for Android")
        else File((mCtx as Context).filesDir, "datastore/$APP_PREFERENCE_DATASTORE").path
    }
)