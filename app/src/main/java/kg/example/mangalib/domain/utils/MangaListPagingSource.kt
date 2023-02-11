package kg.example.mangalib.domain.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kg.example.mangalib.data.mapper.toDataMango
import kg.example.mangalib.data.mapper.toManga
import kg.example.mangalib.data.remote.ApiService
import kg.example.mangalib.domain.model.MangalibModel

const val NETWORK_PAGE_SIZE = 50
private const val INITIAL_LOAD_SIZE = 1

/*
class MangaListPagingSource(
    private val service: ApiService,
    private val query:String
    ) : PagingSource<Int, MangalibModel>() {


        override fun getRefreshKey(state: PagingState<Int, MangalibModel>): Int? {
            val anchorPosition = state.anchorPosition ?: return null
            val page = state.closestPageToPosition(anchorPosition) ?: null
            return page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MangalibModel> {
            if(query.isEmpty()) {
                return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
            }
return try {


            val page: Int = params.key ?: 1
            val pageSize: Int = params.loadSize.coerceAtMost(20)

            val response = service.getAllManga(pageSize, page * pageSize)

                val result = checkNotNull(response).map { it.toDataMango() }
                val nextKey = if (result.size < pageSize) null else page + 1
                val prevKey = if(page == 1) null else page -1
                return LoadResult.Page(result,prevKey, nextKey)
}catch (e:Exception){
                return LoadResult.Error(e)
            }
        }
    }*/
        /*return try {
            val page = params.key ?: 1
            val response =repository.Paging(10,page)

            LoadResult.Page(
                data = response.map { it.data },
                prevKey = null,
                nextKey = if (response.results.isEmpty()) response.count + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }}*/
        /* val position = params.key ?: INITIAL_LOAD_SIZE
        val offset =
            if (params.key != null) ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
        return try {

            val jsonResponse =
            val response = repository.
            val nextKey = if (response.isEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            LoadResult.Page(
                data = response,
                prevKey = null, // Only paging forward.
                // assume that if a full page is not loaded, that means the end of the data
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
*/


