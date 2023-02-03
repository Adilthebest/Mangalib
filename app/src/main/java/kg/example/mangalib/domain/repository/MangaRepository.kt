package kg.example.mangalib.domain.repository

import kg.example.mangalib.domain.utils.Resourse
import kg.example.mangalib.domain.model.MangalibModel
import kg.example.mangalib.domain.model.ResultModel
import kotlinx.coroutines.flow.Flow

interface MangaRepository {
     fun getAllTopManga():Flow<Resourse<List<ResultModel>>>

     fun getAllManga():Flow<Resourse<List<ResultModel>>>

     fun getAllMangaSearch(search:String):Flow<Resourse<List<ResultModel>>>
}