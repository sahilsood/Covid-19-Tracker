package xyz.sahilsood.covid19tracker.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import xyz.sahilsood.covid19tracker.models.News
import xyz.sahilsood.covid19tracker.repositories.AppRepository

class NewsViewModel(
    var appRepository: AppRepository? = AppRepository
) : ViewModel() {
    val newsLiveData: LiveData<News?> = liveData(Dispatchers.IO) {
        val retrievedData = appRepository?.getNewsData()
        if (retrievedData != null) {
            emit(retrievedData)
        }
    }
}