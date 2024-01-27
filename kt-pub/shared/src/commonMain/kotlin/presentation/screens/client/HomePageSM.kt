package presentation.screens.client

import androidx.compose.runtime.collectAsState
import data.network.AppResource
import data.network.AppResponse
import data.network.GigResponse
import data.network.repositories.GigsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
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

    init {
        handleActions(HomePageActions.LoadLatestGigs)
        handleActions(HomePageActions.LoadGigSummary)
    }

    fun handleActions(actions: HomePageActions){
        when(actions){
            is HomePageActions.LoadLatestGigs -> {
                loadLatestGigs()
            }
            is HomePageActions.LoadGigSummary -> {
                loadGigSummary()
            }
            else -> {
                
            }
        }
    }
    
    private fun loadLatestGigs() = launchInIO {
        gigsRepository.getLatestGigs().collect {
            screenDataState.update { homePageUiState ->
                homePageUiState.copy(latestGigsState = it)
            }
        }
    }

    private fun loadGigSummary() = launchInIO {
        gigsRepository.getGigStats().collect {
            screenDataState.update { homePageUiState ->
                homePageUiState.copy(gigSummary = it)
            }
        }
    }
    
}

data class HomePageUiState(
    val latestGigsState: AppResource<AppResponse<List<GigResponse>>> = AppResource.Loading(),
    val gigSummary: AppResource<AppResponse<Map<String, Long>>> = AppResource.Loading()
)

sealed class HomePageActions {
    data object LoadLatestGigs: HomePageActions()
    data object LoadGigSummary: HomePageActions()
}

