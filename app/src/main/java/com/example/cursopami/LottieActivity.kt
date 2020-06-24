package com.example.cursopami

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)
        
        animatorView.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                animatorView.visibility = View.INVISIBLE
            }
        })
    }

    fun animateWashYourHands(v:View){
        animatorView.setAnimation("wash-your-hand.json")
        animatorView.visibility = View.VISIBLE
        animatorView.playAnimation()
    }

    fun animateWearMask(v:View){
        animatorView.setAnimation("wear-mask.json")
        animatorView.visibility = View.VISIBLE
        animatorView.playAnimation()
    }
}
