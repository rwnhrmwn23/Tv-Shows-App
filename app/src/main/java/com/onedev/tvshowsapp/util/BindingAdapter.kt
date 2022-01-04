package com.onedev.tvshowsapp.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:imageURL")
    fun setImageUrl(imageView: ImageView, url: String) {
        try {
            imageView.alpha = 0F
            Picasso.get().load(url).noFade().into(imageView, object : Callback{
                override fun onSuccess() {
                    imageView.animate().setDuration(300).alpha(1F).start()
                }

                override fun onError(e: Exception?) {
                    e.toString()
                }

            })
        } catch (e: Exception) {
            e.toString()
        }
    }
}