package com.example.onmeasure

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Binder
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Palette.from(BitmapFactory.decodeResource(resources,R.mipmap.p1)).maximumColorCount(5).generate(object:Palette.PaletteAsyncListener{
            override fun onGenerated(palette: Palette?) {
                println("iffy palette?.getVibrantSwatch()?.rgb${palette?.getVibrantSwatch()?.rgb}")
                toolbar.setBackgroundColor(palette?.getVibrantSwatch()?.rgb!!)
            }

        })


        //Palette.
         Glide.with(this)
             .asBitmap()
             .load(getDrawable(R.mipmap.p1))
             .into(object : CustomTarget<Bitmap>() {
             override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
                 println("iffy onResourceReady")


                    }


             override fun onLoadCleared(placeholder: Drawable?) {
             }
         })

    }


}
