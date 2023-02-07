package kg.example.mangalib.data.repository

import kg.example.mangalib.data.base.BaseRepository
import kg.example.mangalib.data.mapper.toManga
import kg.example.mangalib.data.remote.ApiService
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.domain.repository.MangaRepository
import kg.example.mangalib.domain.utils.Resourse
import kotlinx.coroutines.flow.Flow

class MangaRepositoryImpl(val api: ApiService) : MangaRepository, BaseRepository() {

    override fun getAllTopManga(): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllTopManga().map { it.toManga() }
    }

    override fun getAllManga(): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllManga().map { it.toManga() }

    }

    override fun getAllMangaSearch(search: String): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllMangaSearch(search).map { it.toManga() }
    }

    override fun getAllMangaId(id: Int): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllMangaId(id).map { it.toManga() }
    }

}




