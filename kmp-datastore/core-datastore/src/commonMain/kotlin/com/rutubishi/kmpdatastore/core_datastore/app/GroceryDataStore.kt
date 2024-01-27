package com.rutubishi.kmpdatastore.core_datastore.app

import androidx.datastore.core.Serializer
import com.rutubishi.kmpdatastore.core_definitions.data.model.GroceryItem
import java.io.InputStream
import java.io.OutputStream


object MessageSerializer: Serializer<GroceryItem>{
    override val defaultValue: GroceryItem
        get() = GroceryItem(
            id = 0, itemCount = 0L, item = "Kales", isChecked = false, updated = "today"
        )

    override suspend fun readFrom(input: InputStream): GroceryItem {
        TODO("Not yet implemented")
    }

    override suspend fun writeTo(t: GroceryItem, output: OutputStream) {
        TODO("Not yet implemented")
    }

}

internal class GroceryDataStore(

)