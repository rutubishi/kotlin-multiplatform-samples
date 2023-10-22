package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import data.network.EmployerDto
import data.network.KtPubAPI
import data.repository.EmployerRepoImpl
import data.repository.GigRepoImpl
import presentation.uimodel.ScreenState

@Composable
fun GigView(
    gigScreenModel: GigScreenModel,
    modifier: Modifier = Modifier,
    employerName: String? = null,
    employerId: Long = 0L
) {

    val employerData: EmployerDto? by gigScreenModel.gigEmployer.collectAsState()
    val gigSearchUiState: GigSearchUiState by gigScreenModel.gigSearchUiState.collectAsState()
    val gigSearchScreenState: ScreenState<String> by gigScreenModel.gigListScreenState.collectAsState()

    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if(employerId != 0L){
            // fetch current employer
            gigScreenModel.fetchEmployer(employerId)

            GigAddView(
                modifier = Modifier
                    .weight(1f),
                screenModel = gigScreenModel,
                employerId = employerData?.id ?: employerId,
                employerName = employerData?.title ?: employerName
            )
        }

        GigList(
            modifier = Modifier
                .weight(1f),
            gigSearchUiState = gigSearchUiState,
            gigSearchScreenState = gigSearchScreenState,
            isWideScreen = employerId == 0L
        )
    }
}