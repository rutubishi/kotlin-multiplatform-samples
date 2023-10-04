package presentation.screens.fragments.gigs

import data.repository.GigRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import presentation.uimodel.ScreenModel

class GigScreenModel(
    val gigRepository: GigRepository
) : ScreenModel {
    override val asyncWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)

    override val uiWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)


}