package presentation.screens.client

import data.network.GigResponse
import data.network.repositories.GigsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import presentation.uimodel.ScreenModel

abstract class HomePageSM(
    private val uiScope: CoroutineScope? = null, 
    private val ioScope: CoroutineScope? = null,
    private val gigsRepository: GigsRepository
) : ScreenModel {

    override val uiWorkScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
        get() = uiScope ?: field

    override val asyncWorkScope: CoroutineScope = CoroutineScope(Dispatchers.Default)
        get() = ioScope ?: field

    
    open val screenDataState: MutableStateFlow<HomePageUiState> = MutableStateFlow(HomePageUiState())
    
    open fun handleActions(actions: HomePageActions){
        when(actions){
            is HomePageActions.LoadLatestGigs -> {
                loadLatestGigs()
            }
            else -> {
                
            }
        }
    }
    
    private fun loadLatestGigs() = launchInIO {
        val gigs = gigsRepository.fetchLatestGigs()
        println("Launched Effect here $gigs")
        screenDataState.update { 
            it.copy(latestGigs = gigs.body)
        }
    }
    
}

data class HomePageUiState(
    val latestGigs: List<GigResponse> = emptyList()
)

sealed class HomePageActions {
    data object LoadLatestGigs: HomePageActions()
}

