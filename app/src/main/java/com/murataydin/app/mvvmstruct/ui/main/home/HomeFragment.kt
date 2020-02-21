package com.murataydin.app.mvvmstruct.ui.main.home

import com.faskn.app.weatherapp.di.Injectable
import com.murataydin.app.mvvmstruct.R
import com.murataydin.app.mvvmstruct.core.BaseFragment
import com.murataydin.app.mvvmstruct.databinding.FragmentHomeBinding
import com.murataydin.app.mvvmstruct.domain.response.DataItem
import com.murataydin.app.mvvmstruct.utils.extensions.observeNonNull

class HomeFragment : BaseFragment<HomeFragmentViewModel, FragmentHomeBinding>(HomeFragmentViewModel::class.java), Injectable {

    override fun getLayoutRes() = R.layout.fragment_home

    override fun initViewModel() {
        mBinding.viewModel = viewModel
    }

    override fun init() {
        super.init()
        initForecastAdapter()

        viewModel.getAllComicList()


        viewModel.dummyComicLiveData.observeNonNull(this){
            render(it)
        }
        }

    private fun render(homeViewState: HomeViewState) {
        with(mBinding) {
            viewState = homeViewState
            executePendingBindings()
        }

        if (homeViewState.isSuccess()) {
            (mBinding.recyclerViewSearchResults.adapter as HomeAdapter).submitList(homeViewState.getComics())

        }
    }

    private fun initForecastAdapter() {
        val adapter = HomeAdapter { item ->
        }

        mBinding.recyclerViewSearchResults.adapter = adapter
        postponeEnterTransition()
        mBinding.recyclerViewSearchResults.viewTreeObserver
                .addOnPreDrawListener {
                    startPostponedEnterTransition()
                    true
                }
    }

    private fun initComics(list: List<DataItem>) {
        (mBinding.recyclerViewSearchResults.adapter as HomeAdapter).submitList(list)
    }
}
