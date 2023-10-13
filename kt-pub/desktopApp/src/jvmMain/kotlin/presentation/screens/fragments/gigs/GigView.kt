package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import data.network.AppResponse
import data.network.EmployerDto
import data.network.KtPubAPI
import data.repository.EmployerRepoImpl
import data.repository.GigRepoImpl

@Composable
fun GigView(
    modifier: Modifier = Modifier,
    gigScreenModel: GigScreenModel = GigScreenModel(
        gigRepository = GigRepoImpl(client = KtPubAPI.client),
        employerRepository = EmployerRepoImpl(client = KtPubAPI.client)
    ),
    employerName: String? = null,
    employerId: Long = 0L
) {

    val employerData: AppResponse<EmployerDto?> by gigScreenModel.gigEmployer.collectAsState()

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
                employerId = employerData.body?.id ?: employerId,
                employerName = employerData.body?.title ?: employerName
            )
        }

        GigList(
            modifier = Modifier
                .weight(1f)
        )
    }
}