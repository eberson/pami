package br.com.etecmatao.meucursodeandroid

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)

        animationView.addAnimatorListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                animationView.visibility = View.INVISIBLE
            }
        })
    }

    fun washYourHand(v:View){
        animationView.setAnimation("wash-your-hand.json")
        animationView.visibility = View.VISIBLE
        animationView.playAnimation()
    }

    fun wearMask(v:View){
        animationView.setAnimation("wear-mask.json")
        animationView.visibility = View.VISIBLE
        animationView.playAnimation()
    }
}
