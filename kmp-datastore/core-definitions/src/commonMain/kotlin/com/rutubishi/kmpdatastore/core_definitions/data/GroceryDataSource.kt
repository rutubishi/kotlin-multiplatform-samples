package com.rutubishi.kmpdatastore.core_definitions.data

import com.rutubishi.kmpdatastore.core_definitions.data.model.GroceryItem
import kotlinx.coroutines.flow.Flow

interface GroceryDataSource {
    suspend fun addGroceryItem(groceryItem: GroceryItem): Flow<GroceryItem?>
    suspend fun updateGroceryItem(groceryItem: GroceryItem): Flow<Boolean>
    suspend fun deleteGroceryItem(id: Int): Flow<Boolean>
    suspend fun showGroceryItems(): Flow<List<GroceryItem>>
}