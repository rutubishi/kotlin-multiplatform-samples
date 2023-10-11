package presentation.screens.fragments.gigs

import data.repository.EmployerRepository
import data.repository.GigRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import presentation.uimodel.ScreenModel
import presentation.uimodel.ScreenState

class GigScreenModel(
    val gigRepository: GigRepository,
    val employerRepository: EmployerRepository
) : ScreenModel {
    override val asyncWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)

    override val uiWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main)

    val uiState: MutableStateFlow<GigAddUiState> =
        MutableStateFlow(GigAddUiState())

    private val _addGigState: MutableStateFlow<ScreenState<String>> =
        MutableStateFlow(ScreenState.Idle(data = "No action needed"))
    val addGigState: StateFlow<ScreenState<String>> = _addGigState




    fun handleGigAddActions(actions: GigAddActions){
        when(actions){
            is GigAddActions.BenefitsChange -> {
                uiState.update { it.copy(roleBenefits = actions.benefits) }
            }
            is GigAddActions.ContractTypeChange -> {
                uiState.update { it.copy(contractType = actions.contractType) }
            }
            is GigAddActions.DescriptionChange -> {
                uiState.update { it.copy(roleDesc = actions.description) }
            }
            is GigAddActions.LocTypeChange -> {
                uiState.update { it.copy(roleLocation = actions.locType) }
            }
            is GigAddActions.LocationChange -> {
                uiState.update { it.copy(location = actions.location) }
            }
            is GigAddActions.RequirementChange -> {
                uiState.update { it.copy(roleRequirement = actions.requirement) }
            }
            is GigAddActions.RoleTypeChange -> {
                uiState.update { it.copy(roleType = actions.roleType) }
            }
            is GigAddActions.SalaryRangeChange -> {
                uiState.update { it.copy(salaryRange = actions.salaryRange) }
            }
            is GigAddActions.TitleChange -> {
                uiState.update { it.copy(roleName = actions.title) }
            }
            is GigAddActions.SubmitGig -> {
                uiState.update { it.copy(employerId = actions.employerId) }
                if(uiState.value.valid()){
                    //TODO: Make network call
                    submitGigForm()
                }else{
                    println("error when submitting")
                    //TODO:Show error
                }
            }
        }
    }

    private fun getCurrentUiState(): GigAddUiState = uiState.value
    private fun submitGigForm() = launchInIO {
        val current = getCurrentUiState()
        _addGigState.emit(value = ScreenState.Loading())
        val gig = gigRepository.createGig(gig = uiState.value.getGigRequest())
        if(gig.body != null){
            uiState.update { GigAddUiState() }
            _addGigState.emit(ScreenState.Success(data = gig.status))
        }else{
            uiState.update { current }
            _addGigState.emit(ScreenState.Error(message = gig.status))
        }
    }

    private fun fetchEmployer(id: Long) = launchInIO {

    }

}