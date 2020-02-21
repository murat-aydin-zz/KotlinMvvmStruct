package com.murataydin.app.mvvmstruct.ui.main.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.murataydin.app.mvvmstruct.core.BaseAdapter
import com.murataydin.app.mvvmstruct.databinding.ItemComicBinding
import com.murataydin.app.mvvmstruct.domain.response.DataItem


class HomeAdapter(private val callBack: (DataItem) -> Unit) : BaseAdapter<DataItem>(diffCallback) {

    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val mBinding = ItemComicBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
        )
        val viewModel = ComicsItemViewModel()
        mBinding.viewModel = viewModel

        return mBinding
    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemComicBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}

val diffCallback = object : DiffUtil.ItemCallback<DataItem>() {
    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean =
            oldItem == newItem

    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean =
            oldItem == newItem
}
