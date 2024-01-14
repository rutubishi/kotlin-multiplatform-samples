package datasource

import kotlinx.coroutines.flow.Flow
import model.GroceryItem

interface GroceryDataStore {
    suspend fun addGroceryItem(item: GroceryItem): Flow<Boolean>
    suspend fun updateGroceryItem(item: GroceryItem): Flow<GroceryItem?>
    suspend fun deleteGroceryItem(itemId: Long): Flow<Boolean>
    suspend fun fetchGroceryItems(): Flow<List<GroceryItem>>
}
