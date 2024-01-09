package presentation.screens.fragments.employers

import data.repository.EmployerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.uimodel.ScreenModel
import presentation.uimodel.ScreenState

class EmployerScreenModel(
    private val employerRepository: EmployerRepository
) : ScreenModel {

    init {
        loadEmployers()
    }

    override val asyncWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)
    override val uiWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)

    val uiState: MutableStateFlow<EmployerAddUiState> =
        MutableStateFlow(EmployerAddUiState())

    private val _addEmployerState: MutableStateFlow<ScreenState<String>> =
        MutableStateFlow(ScreenState.Idle(data = "No action needed"))
    val addEmployerState: StateFlow<ScreenState<String>> = _addEmployerState


    val searchUiState: MutableStateFlow<EmployerSearchUiState> =
        MutableStateFlow(EmployerSearchUiState())
    private val _searchState: MutableStateFlow<ScreenState<String?>> =
        MutableStateFlow(ScreenState.Idle(data = "No action needed"))
    val searchState: StateFlow<ScreenState<String?>> = _searchState

    fun handleEmployerAddActions(actions: EmployerAddActions) {
        when(actions){
            is EmployerAddActions.AddEmployer -> {
                if (uiState.value.valid()){
                    submitEmployerForm()
                }
                else{
                    asyncWorkScope.launch {
                        _addEmployerState.emit(
                            ScreenState.Error(message = "You need to fill in all the fields!")
                        )
                    }
                }
            }
            is EmployerAddActions.CompanySizeChange -> {
                uiState.update {
                    it.copy(companySize = actions.companySize)
                }
            }
            is EmployerAddActions.DescriptionChange -> {
                uiState.update {
                    it.copy(description = actions.description)
                }
            }
            is EmployerAddActions.IndustryChange -> {
                uiState.update {
                    it.copy(industry = actions.industry)
                }
            }
            is EmployerAddActions.LogoChange -> {
                uiState.update {
                    it.copy(logo = actions.logo)
                }
            }
            is EmployerAddActions.WebPageChange -> {
                uiState.update {
                    it.copy(webPage = actions.webPage)
                }
            }

            is EmployerAddActions.CompanyNameChange -> {
                uiState.update {
                    it.copy(companyName = actions.companyName)
                }
            }
        }
    }

    fun handleSearchActions(actions: EmployerSearchActions) = launchInIO <Unit>{
        when(actions){
            is EmployerSearchActions.SearchChange -> {
                searchUiState.update {
                    it.copy(searchTerm = actions.searchTerm)
                }
            }
            EmployerSearchActions.SubmitSearch -> {
                _searchState.emit(ScreenState.Loading())
                searchUiState.update {
                    loadEmployers(searchTerm = it.searchTerm)
                    it.copy(searchTerm = "")
                }
            }
        }
    }

    private fun getCurrentUiState(): EmployerAddUiState = uiState.value

    private fun submitEmployerForm() = launchInIO {
        val current = getCurrentUiState()
        _addEmployerState.emit(value = ScreenState.Loading())
        val employer = employerRepository
                .createEmployer(employer = uiState.value.getEmployerDto())
        if(employer.body != null){
            uiState.emit(EmployerAddUiState())
            _addEmployerState.emit(ScreenState.Success(data = employer.status))
            loadEmployers()
        }else{
            uiState.emit(current)
            _addEmployerState.emit(ScreenState.Error(message = employer.status))
        }
    }

    private fun loadEmployers(searchTerm: String? = null) = launchInIO {
//        _searchState.emit(value = ScreenState.Loading(data = null))
        val employers = if(searchTerm == null)
            employerRepository.showEmployers()
        else
            employerRepository.showEmployers()

        searchUiState.update {
            it.copy(searchResults = employers.body?: emptyList())
        }
        _searchState.emit(value = ScreenState.Success(data = "Data Loaded"))
    }

}