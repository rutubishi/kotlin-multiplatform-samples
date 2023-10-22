package presentation.screens.fragments.employers

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import data.network.KtPubAPI
import data.repository.EmployerRepoImpl
import presentation.screens.AdminScreenModel

@Composable
fun EmployerView(
    modifier: Modifier = Modifier,
    employerScreenModel: EmployerScreenModel,
    adminScreenModel: AdminScreenModel
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        EmployerAddView(
            modifier = Modifier
                .weight(1f),
            viewModel = employerScreenModel
        )
        EmployerList(
            modifier = Modifier
                .weight(1f),
            viewModel = employerScreenModel,
            adminScreenModel = adminScreenModel
        )
    }

}