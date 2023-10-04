package presentation.screens.fragments.gigs

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import data.network.KtPubAPI
import data.repository.GigRepoImpl

@Composable
fun GigView(
    modifier: Modifier = Modifier,
    gigScreenModel: GigScreenModel = GigScreenModel(
        gigRepository = GigRepoImpl(client = KtPubAPI.client)
    ),
    employerName: String? = null,
    employerId: Long = 0L
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if(employerId != 0L)
            GigAddView(
                modifier = Modifier
                    .weight(1f),
                screenModel = gigScreenModel,
                employerId = employerId,
                employerName = employerName
            )

        GigList(
            modifier = Modifier
                .weight(1f)
        )
    }
}