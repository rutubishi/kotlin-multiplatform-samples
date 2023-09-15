package presentation.screens.fragments.employers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import presentation.uimodel.ScreenModel
import presentation.uimodel.ScreenState

class EmployerScreenModel : ScreenModel() {
    override val asyncWorkScope: CoroutineScope
        get() = CoroutineScope(Dispatchers.IO)

    val uiState: MutableStateFlow<ScreenState<EmployerAddUiState>> =
        MutableStateFlow(ScreenState.Success(data = EmployerAddUiState()))


    fun handleEmployerAddActions(actions: EmployerAddActions){
        when(actions){
            is EmployerAddActions.AddEmployer -> {
                if (uiState.value.data?.valid() == true){
                    asyncWorkScope.launch {

                    }
                }
            }
            is EmployerAddActions.CompanySizeChange -> TODO()
            is EmployerAddActions.DescriptionChange -> TODO()
            is EmployerAddActions.IndustryChange -> TODO()
            is EmployerAddActions.LogoChange -> TODO()
            is EmployerAddActions.WebPageChange -> TODO()
        }
    }

}