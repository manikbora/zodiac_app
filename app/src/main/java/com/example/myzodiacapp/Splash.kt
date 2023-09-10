package com.example.myzodiacapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.example.myzodiacapp.databinding.ActivitySplashBinding

class Splash : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val zoomInAnim = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        binding.ivLogo.startAnimation(zoomInAnim)

        val slideLeftAnim = AnimationUtils.loadAnimation(this, R.anim.slide_left)
        binding.tvWelcome.startAnimation(slideLeftAnim)

        val slideRightAnim = AnimationUtils.loadAnimation(this, R.anim.slide_right)
        binding.tvAppName.startAnimation(slideRightAnim)

        val dyingStarAnim = AnimationUtils.loadAnimation(this, R.anim.dying_star)
        dyingStarAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationRepeat(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.ivStar.isVisible = false
            }
        })

        binding.ivStar.startAnimation(dyingStarAnim)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },3000)
    }
}