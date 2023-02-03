package kg.example.mangalib.presentation.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import kg.example.mangalib.databinding.FragmentAllMangaBinding
import kg.example.mangalib.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllMangaFragment : BaseFragment<FragmentAllMangaBinding>() {
    private val viewModel: AllMangaViewModel by viewModel()
private lateinit var adapter: MangaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun inflate(layoutInflater: LayoutInflater): FragmentAllMangaBinding {
        return FragmentAllMangaBinding.inflate(layoutInflater)
    }


    override fun initListener() {
        adapter = MangaAdapter()


        viewModel.getAllManga()
        viewModel.getAllManga.collectState(
            onLoading = {

            },
            Error = {
                Log.e("ololo", "error: " )

            },
            onSuccess = {
                binding.recycle.adapter =adapter
                adapter.array(it)
Toast.makeText(requireContext(),"success",Toast.LENGTH_SHORT).show()
                Log.e("ololo", "success: " )
            })
    }

    override fun initView() {


    }


}