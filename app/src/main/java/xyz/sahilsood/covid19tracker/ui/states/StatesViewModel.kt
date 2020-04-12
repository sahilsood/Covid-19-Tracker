package xyz.sahilsood.covid19tracker.ui.states

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import xyz.sahilsood.covid19tracker.models.States
import xyz.sahilsood.covid19tracker.repositories.AppRepository

class StatesViewModel(
    var appRepository: AppRepository? = AppRepository
) : ViewModel() {

    val stateLiveData: LiveData<States?> = liveData(Dispatchers.IO) {
        val retrievedStateData = appRepository?.stateLiveData()
        if (retrievedStateData != null) {
            emit(retrievedStateData)
        }
    }
}