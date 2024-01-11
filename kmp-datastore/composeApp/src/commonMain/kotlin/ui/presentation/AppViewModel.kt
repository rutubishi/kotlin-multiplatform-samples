package ui.presentation

import repository.ShoppingItemsRepository

class AppViewModel {
    private val repo = ShoppingItemsRepository()
    init {
        repo.testMessage()
    }
}