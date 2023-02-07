package kg.example.mangalib.presentation.ui.fragment.open

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import kg.example.mangalib.databinding.FragmentOpenBinding
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.presentation.ui.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.manga.AllMangaViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class OpenFragment : BaseFragment<FragmentOpenBinding>() {
    private val viewModel: OpenViewModel by viewModel()
lateinit var adapter: OpenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun inflate(layoutInflater: LayoutInflater): FragmentOpenBinding {
        return FragmentOpenBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val result = arguments?.getInt("key" )
        if (result != null) {
            viewModel.getAllMangaId(result)
        }

    }

    override fun initListener() {
viewModel.getAllMangaId.collectState({},{
},{
    Log.e("ololo", "result:${it} ", )
    Toast.makeText(requireContext(), "id${it}", Toast.LENGTH_SHORT).show()

})
    }


}