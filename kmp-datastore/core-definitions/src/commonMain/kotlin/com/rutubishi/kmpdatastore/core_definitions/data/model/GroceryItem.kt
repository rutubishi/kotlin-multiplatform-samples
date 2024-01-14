package com.rutubishi.kmpdatastore.core_definitions.data.model

data class GroceryItem(
    var id: Int = 0,
    val itemCount: Long,
    val item: String,
    var isChecked: Boolean,
    val updated: String
)
