package kg.example.mangalib.di

import kg.example.mangalib.presentation.ui.activity.ui.home.HomeViewModel
import kg.example.mangalib.presentation.ui.fragment.TopMangaViewModel
import kg.example.mangalib.presentation.ui.fragment.AllMangaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        TopMangaViewModel(get())
    }
    viewModel {
        AllMangaViewModel(get())

    }
    viewModel {
        HomeViewModel(get())

    }
}