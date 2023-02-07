package kg.example.mangalib.data.mapper

import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.data.remote.model.ResultDto


fun ResultModel.toMangas() = ResultDto(


    chapters_quantity,
    created_at,
    en_name,
    en_name, genre, id, image, issue_year, likes, rating, ru_name, dir, type, updated_at

)


fun ResultDto.toManga(): ResultModel {
    return ResultModel(
        chapters_quantity,
        created_at,
        en_name,
        genre,
        id,
        image,
        issue_year,
        likes,
        rating,
        ru_name,
        dir,
        type,
        updated_at,
        description ?: ""


    )
}


/*
fun MangalibModel.toDataMango() = kg.example.mangalib.domain.model.MangalibModel(
    count,
    next,
    previous,
    results.map { it.toManga() }
)
fun kg.example.mangalib.domain.model.MangalibModel.toDomainManga() = MangalibModel(
    count,
    next,
    previous,
    results.map { it.toManga() }
)
*/
