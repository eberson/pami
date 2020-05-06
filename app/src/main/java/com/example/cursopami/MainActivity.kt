package com.example.cursopami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickHere(v: View){
        Toast.makeText(
            this,
            getString(R.string.msg_seja_bem_vindo
        ), Toast.LENGTH_SHORT).show();
    }
}
