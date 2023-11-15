package presentation.screens.fragments.employers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import presentation.components.AppError
import presentation.components.AppErrorCard
import presentation.components.AppLoader
import presentation.components.DesktopInput
import presentation.theme.general_padding
import presentation.theme.half_padding
import presentation.uimodel.ScreenState

@Composable
fun EmployerAddView(
    modifier: Modifier = Modifier,
    viewModel: EmployerScreenModel,
) {

    val uiState: EmployerAddUiState by viewModel.uiState.collectAsState(initial = EmployerAddUiState())
    val addEmployerState: ScreenState<String> by viewModel.addEmployerState.collectAsState()

    when(addEmployerState){
        is ScreenState.Error -> EmployerAddViewContent(
            modifier = modifier,
            uiState = uiState,
            viewModel = viewModel,
            error = addEmployerState.message
        )
        is ScreenState.Loading -> AppLoader(modifier = modifier)
        else -> EmployerAddViewContent(
            modifier = modifier,
            uiState = uiState,
            viewModel = viewModel,
        )
    }



}

@Composable
fun EmployerAddViewContent(
    error: String? = null,
    modifier: Modifier,
    uiState: EmployerAddUiState,
    viewModel: EmployerScreenModel,
) {

    var companyDropdownMenuShown by remember { mutableStateOf(false) }
    var showError: Boolean by remember { mutableStateOf(!error.isNullOrBlank()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = general_padding, horizontal = general_padding)
            .verticalScroll(rememberScrollState()),
    ) {


        Text(
            text = "Add Employer",
            style = MaterialTheme.typography.titleLarge,
            fontSize = TextUnit(value = 20f, TextUnitType.Sp),
            color = MaterialTheme.colorScheme.onSurface
        )

        if (showError) AppErrorCard(message = error ?: "Something wrong happened")

        DesktopInput(
            value = uiState.companyName ?: "",
            onValueChange = { viewModel.handleEmployerAddActions(actions = EmployerAddActions.CompanyNameChange(it)) },
            placeholder = {
                Text(
                    text = "Company Name",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )

        DesktopInput(
            value = uiState.logo ?: "",
            onValueChange = { viewModel.handleEmployerAddActions(actions = EmployerAddActions.LogoChange(it)) },
            placeholder = {
                Text(
                    text = "Logo URL",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )

        DesktopInput(
            value = uiState.webPage ?: "",
            onValueChange = {
                viewModel.handleEmployerAddActions(actions = EmployerAddActions.WebPageChange(it))
            },
            placeholder = {
                Text(
                    text = "Webpage",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )

        DesktopInput(
            value = uiState.industry ?: "",
            onValueChange = { viewModel.handleEmployerAddActions(actions = EmployerAddActions.IndustryChange(it)) },
            placeholder = {
                Text(
                    text = "Industry (Education, Hospitality etc.)",
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        )

        DesktopInput(
            value = uiState.companySize ?: "",
            onValueChange = { viewModel.handleEmployerAddActions(EmployerAddActions.CompanySizeChange(it)) },
            placeholder = {
                Text(
                    text = "Company Size",
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (companyDropdownMenuShown) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    modifier = Modifier.clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(),
                        onClick = { companyDropdownMenuShown = !companyDropdownMenuShown }
                    )
                )
            }
        )

        CompanySizeDropdown(
            modifier = Modifier.align(Alignment.End),
            isExpanded = companyDropdownMenuShown
        ){ itemSelected ->
            companyDropdownMenuShown = false
            viewModel.handleEmployerAddActions(EmployerAddActions.CompanySizeChange(itemSelected))
        }

        DesktopInput(
            value = uiState.description ?: "",
            onValueChange = { viewModel.handleEmployerAddActions(EmployerAddActions.DescriptionChange(it)) },
            placeholder = {
                Text(
                    text = "Employer Details",
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            minLines = 6
        )

        Button(
            onClick = {
                viewModel.handleEmployerAddActions(EmployerAddActions.AddEmployer)
                showError = !uiState.valid() },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = half_padding),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ){
            Text(
                text = "Add Employer",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(general_padding)
            )
        }

    }

}

@Composable
fun CompanySizeDropdown(
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false,
    onItemClick: (String) -> Unit = {}
) {
    val sizes = arrayOf("SMALL", "MEDIUM", "LARGE", "MULTINATIONAL")
    Box(
        modifier = modifier
            .width(200.dp)
    ) {
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { },
            modifier = Modifier
                .padding(horizontal = half_padding),
            properties = PopupProperties(
                clippingEnabled = true,
                dismissOnClickOutside = true
            )
        ){
            sizes.forEach {
                DropdownMenuItem(
                    onClick = { onItemClick(it) },
                ){
                    Text(text = it)
                }
            }
        }
    }

}

