package kg.example.mangalib.presentation.ui.fragment

import androidx.lifecycle.viewModelScope
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.domain.usecase.GetAllMangaUseCase
import kg.example.mangalib.domain.usecase.GetAllTopMangaUseCase
import kg.example.mangalib.domain.utils.Resourse
import kg.example.mangalib.domain.utils.UiState
import kg.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AllMangaViewModel(
    private val getAllMangaUseCase: GetAllMangaUseCase
) : BaseViewModel() {
    private val _getAllManga = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getAllManga = _getAllManga.asStateFlow()

    fun getAllManga() {
        getAllMangaUseCase.getAllManga().onEach { result->
            when(result){
                is Resourse.Success ->{
                    _getAllManga.value=UiState.Success(result.data!!)

                }
                is Resourse.Error ->{
                    _getAllManga.value = UiState.Error(result.message!!)

                }
                is Resourse.Loading ->{
                    _getAllManga.value = UiState.Loading()

                }
            }
        }.launchIn(viewModelScope)
    }

}