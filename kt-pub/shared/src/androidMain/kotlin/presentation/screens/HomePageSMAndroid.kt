package presentation.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.network.repositories.GigsRepository
import presentation.screens.client.HomePageSM

class HomePageSMAndroid(
    private val gigsRepository: GigsRepository
) : ViewModel() {
    val screen  = object : HomePageSM(
        uiScope = viewModelScope,
        ioScope = viewModelScope,
        gigsRepository = gigsRepository
    ){}
}
