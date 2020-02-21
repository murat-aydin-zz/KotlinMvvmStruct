package com.murataydin.app.mvvmstruct.core

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.murataydin.app.mvvmstruct.R
import com.murataydin.app.mvvmstruct.utils.extensions.hide
import com.murataydin.app.mvvmstruct.utils.extensions.show
import com.squareup.picasso.Picasso

@BindingAdapter("app:setDrawableLink")
fun setDrawableLink(view: ImageView, link: String?) {
    if (link.isNullOrEmpty())
        return

    Picasso.get()
            .load(link)
            .fit()
            .into(view)

}

@BindingAdapter("app:visibility")
fun setVisibilty(view: View, isVisible: Boolean) {
    if (isVisible) {
        view.show()
    } else {
        view.hide()
    }
}

@BindingAdapter("app:setErrorView")
fun setErrorView(view: View, viewState: BaseViewState?) {
    if (viewState?.shouldShowErrorMessage() == true)
        view.show()
    else
        view.hide()
}

@BindingAdapter("app:setErrorText")
fun setErrorText(view: TextView, viewState: BaseViewState?) {
    if (viewState?.shouldShowErrorMessage() == true)
        view.text = viewState.getErrorMessage()?.localizedMessage
    else
        view.text = view.context.getString(R.string.unexpected_exception)
}
