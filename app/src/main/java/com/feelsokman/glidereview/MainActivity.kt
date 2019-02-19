package com.feelsokman.glidereview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.feelsokman.glidereview.glide.GlideApp
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // the URL we want to load
        val url = "https://media.giphy.com/media/cYxLgjZI5ezI2lrItX/giphy.gif"

        val circularProgressDrawable = createSpinner()

        loadUrlIntoImageView(url, circularProgressDrawable)
    }

    /**
     *  a basic spinner created programmatically
     *  this is something that you typically stumble upon on Stack Overflow
     */
    private fun createSpinner(): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(this@MainActivity)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        return circularProgressDrawable
    }

    /**
     *   The spinner acts as a placeholder while loading the url
     *   On error will show R.drawable.ic_launcher_foreground
     */
    private fun loadUrlIntoImageView(url: String, circularProgressDrawable: CircularProgressDrawable) {
        GlideApp.with(this@MainActivity)
            .load(url)
            .placeholder(circularProgressDrawable)
            .error(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }
}
