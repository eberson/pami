package com.example.cursopami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*
import org.w3c.dom.Text

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun calculate(v: View){
        txtNumeroA.error = null
        txtNumeroB.error = null

        val numeroA = txtNumeroA.text.toString()
        val numeroB = txtNumeroB.text.toString()

        if (TextUtils.isEmpty(numeroA)){
            txtNumeroA.error = getString(R.string.msg_campo_obrigatorio)
            return
        }

        if (TextUtils.isEmpty(numeroB)){
            txtNumeroB.error = getString(R.string.msg_campo_obrigatorio)
            return
        }

        //Integer.parseInt é um método que convert string em int
        val valorA = Integer.parseInt(numeroA)
        val valorB = Integer.parseInt(numeroB)
        val resultado = valorA + valorB

        Toast.makeText(
            this,
            getString(R.string.msg_resultado_calculo, valorA, valorB, resultado),
            Toast.LENGTH_SHORT
        ).show()
    }
}
