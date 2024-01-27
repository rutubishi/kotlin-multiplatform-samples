package com.rutubishi.kmpdatastore.core_data.datasource

import com.rutubishi.kmpdatastore.core_definitions.data.GroceryDataSource
import com.rutubishi.kmpdatastore.core_definitions.data.model.GroceryItem
import kotlinx.browser.window
import kotlinx.coroutines.flow.Flow


actual fun buildGroceryStore(): GroceryDataSource {
    return object : GroceryDataSource {

        init {

        }

        override suspend fun addGroceryItem(groceryItem: GroceryItem): Flow<GroceryItem?> {
            TODO("Not yet implemented")
        }

        override suspend fun updateGroceryItem(groceryItem: GroceryItem): Flow<Boolean> {
            TODO("Not yet implemented")
        }

        override suspend fun deleteGroceryItem(id: Int): Flow<Boolean> {
            TODO("Not yet implemented")
        }

        override suspend fun showGroceryItems(): Flow<List<GroceryItem>> {
            TODO("Not yet implemented")
        }
    }
}