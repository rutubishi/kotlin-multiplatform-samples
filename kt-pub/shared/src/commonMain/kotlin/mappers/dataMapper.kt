package mappers

fun String.toEnumString(): String = uppercase().replace("-", "_")