package com.murataydin.app.mvvmstruct.ui.home

import com.murataydin.app.mvvmstruct.R
import com.murataydin.app.mvvmstruct.core.BaseFragment
import com.murataydin.app.mvvmstruct.databinding.FragmentHomeBinding
import com.murataydin.app.mvvmstruct.di.Injectable
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import com.murataydin.app.mvvmstruct.domain.usecase.ComicsUseCase
import com.murataydin.app.mvvmstruct.utils.extensions.observeNonNull
import com.murataydin.app.mvvmstruct.utils.extensions.observeWith

class HomeFragment : BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(R.layout.fragment_home, HomeFragmentViewModel::class.java), Injectable {

    override fun init() {
        super.init()
        initComicsAdapter()

        viewModel.setComicsParams(ComicsUseCase.ComicsParams())


        viewModel.getComicsViewState().observeWith(
                viewLifecycleOwner
        ) {
            with(binding) {
                viewState = it
                it.data?.data?.let { comics -> initComics(comics) }
            }
        }
    }

    private fun initComicsAdapter() {
        val adapter = HomeAdapter { item ->
            // TODO - RecyclerView click
        }

        binding.recyclerViewSearchResults.adapter = adapter
        postponeEnterTransition()
        binding.recyclerViewSearchResults.viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
    }

    private fun initComics(list: List<DataItem?>?) {
        (binding.recyclerViewSearchResults.adapter as HomeAdapter).submitList(list)
    }
}
