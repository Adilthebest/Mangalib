package kg.example.mangalib.presentation.ui.activity.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kg.example.mangalib.databinding.FragmentHomeBinding
import kg.example.mangalib.presentation.ui.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.AllMangaViewModel
import kg.example.mangalib.utils.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initListener() {

        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(parentFragmentManager)
        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
if (p0 !==null){
viewModel.getMangaSearch(p0)
}
return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return true
            }

        })
    }


    override fun initView() {
        viewModel.getMangaSearch.collectState(
            onLoading = {

            },
            Error = {
                Log.e("ololo", "error: ")

            },
            onSuccess = {
                Log.e("ololo", "success: ")

            })
    }
}
