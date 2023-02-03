package kg.example.mangalib.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import kg.example.mangalib.data.remote.model.ResultDto
interface ApiService {
    @GET("v1/top-manga")
    suspend fun getAllTopManga():List<ResultDto>

    @GET("v1/manga/")
    suspend fun getAllManga():List<ResultDto>

    @GET("/api/v1/manga/{id}/")
    suspend fun getAllMangaId(
        @Path("id") id:Int
    ):List<ResultDto>

    @GET("v1/manga/")
    suspend fun getAllMangaSearch(
        @Query("search") search :String
    ):List<ResultDto>

}