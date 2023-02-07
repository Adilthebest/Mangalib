package kg.example.mangalib.presentation.ui.activity.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.coroutineScope
import kg.example.mangalib.databinding.FragmentHomeBinding
import kg.example.mangalib.presentation.ui.base.BaseFragment
import kg.example.mangalib.presentation.ui.fragment.MangaAdapter
import kg.example.mangalib.utils.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()
    lateinit   var adapter: MangaAdapter

    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter= MangaAdapter()

    }
    override fun initListener() {

        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(parentFragmentManager)

    }


    override fun initView() {
        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {

                p0.let {
                    viewModel.getMangaSearch(it)
                }

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return false
            }

        })

        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.getMangaSearch.collectState({

            },{
                Log.e("ololo", "error:${it} " )

            },{
                adapter.array(it)
                Toast.makeText(requireContext(),"success",Toast.LENGTH_SHORT).show()
                Log.e("ololo", "success: " )
            })
               /* if (result.isLoading){
                    binding.viewPager.visibility = View.VISIBLE
                }
                if (result.error.isNotEmpty()){
                    binding.progress.visibility = View.GONE

                }
                result.data?.let {
                    Log.e("ololo", "success:${it} " )

                    binding.progress.visibility = View.GONE
                    adapter.array(it)
                }*/
            }
        }

}
