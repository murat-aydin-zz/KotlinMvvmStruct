package com.murataydin.app.mvvmstruct.core

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import com.murataydin.app.mvvmstruct.R
import com.squareup.picasso.Picasso


object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:setDrawableLink")
    fun setDrawableLink(view: ImageView, link: String?) {
        if (link.isNullOrEmpty())
            return

        Picasso.get()
                .load(link)
                .fit()
                .into(view)

    }
}