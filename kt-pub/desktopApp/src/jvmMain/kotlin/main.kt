import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import data.network.KtPubAPI
import data.repository.EmployerRepoImpl
import data.repository.GigRepoImpl
import presentation.screens.AdminHome
import presentation.screens.AdminScreenModel
import presentation.screens.fragments.employers.EmployerScreenModel
import presentation.screens.fragments.gigs.GigScreenModel
import kotlin.system.exitProcess

fun main() = application {

    val client = KtPubAPI.client

    val gigRepository = GigRepoImpl(client = client)
    val employerRepository = EmployerRepoImpl(client = client)

    val screenModel = AdminScreenModel()
    val gigScreenModel = GigScreenModel(gigRepository, employerRepository)
    val employerScreenModel = EmployerScreenModel(employerRepository)

    Window(
        onCloseRequest = ::exitApplication,
        title = "kt-pub Admin",
        resizable = false,
        state = WindowState(
            size = DpSize(
                width = 1280.dp,
                height = 1080.dp
            )
        )
    ) {
        AdminHome(
            closeRequest = {
                exitProcess(0)
            },
            adminScreenModel = screenModel,
            employerScreenModel, gigScreenModel
        )
    }
}