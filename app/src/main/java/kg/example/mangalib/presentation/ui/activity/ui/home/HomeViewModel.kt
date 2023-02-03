package kg.example.mangalib.presentation.ui.activity.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.domain.usecase.GetMangaSearchUseCase
import kg.example.mangalib.domain.utils.UiState
import kg.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel (
    private val getMangaSearchUseCase: GetMangaSearchUseCase
    ): BaseViewModel() {

    private val _getAllMangaSearch = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getMangaSearch = _getAllMangaSearch.asStateFlow()

    fun getMangaSearch(search:String) {
        getMangaSearchUseCase.getMangaSearch(search).collectFlow(_getAllMangaSearch)
    }

}