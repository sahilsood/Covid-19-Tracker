package xyz.sahilsood.covid19tracker.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import xyz.sahilsood.covid19tracker.models.States
import xyz.sahilsood.covid19tracker.models.Summary
import xyz.sahilsood.covid19tracker.repositories.AppRepository

class DashboardViewModel(
    var appRepository: AppRepository? = AppRepository
) : ViewModel() {

    val summaryLiveData: LiveData<Summary?> = liveData(Dispatchers.IO) {
        val retrievedSummaryData = appRepository?.summaryLiveData()
        if (retrievedSummaryData != null) {
            emit(retrievedSummaryData)
        }
    }

    val stateLiveData: LiveData<States?> = liveData(Dispatchers.IO) {
        val retrievedStateData = appRepository?.stateLiveData()
        if (retrievedStateData != null) {
            emit(retrievedStateData)
        }
    }
}
