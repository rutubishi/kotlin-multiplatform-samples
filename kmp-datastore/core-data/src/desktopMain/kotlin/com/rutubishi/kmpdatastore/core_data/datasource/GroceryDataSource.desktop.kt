package com.rutubishi.kmpdatastore.core_data.datasource

import com.rutubishi.kmpdatastore.core_datastore.app.AppGroceryDataSource
import com.rutubishi.kmpdatastore.core_definitions.data.GroceryDataSource

actual fun buildGroceryStore(): GroceryDataSource {
    return AppGroceryDataSource
}