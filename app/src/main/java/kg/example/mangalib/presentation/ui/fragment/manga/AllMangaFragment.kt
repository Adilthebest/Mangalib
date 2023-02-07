package kg.example.mangalib.presentation.ui.fragment.manga

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import kg.example.mangalib.R
import kg.example.mangalib.databinding.FragmentAllMangaBinding
import kg.example.mangalib.presentation.ui.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.MangaAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllMangaFragment : BaseFragment<FragmentAllMangaBinding>() {
    private val viewModel: AllMangaViewModel by viewModel()
    lateinit var adapter: MangaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MangaAdapter()

    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentAllMangaBinding {
        return FragmentAllMangaBinding.inflate(layoutInflater)
    }


    override fun initListener() {

        viewModel.getAllManga()
        lifecycle.coroutineScope.launchWhenCreated {

            viewModel.getAllManga.collectState(
                onLoading = {

                },
                Error = {
                    Log.e("ololo", "error: ")

                },
                onSuccess = {
                    binding.recycle.adapter = adapter
                    adapter.array(it)
                    Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                    Log.e("ololo", "success: ")
                })
        }
    }

    override fun initView() {


        adapter.onClick = {
            val bundle = Bundle()
            bundle.putInt("key", it.id)
            Log.e("ololo", "initView:${it} ", )
            findNavController().navigate(R.id.openFragment, bundle)
        }

    }
}