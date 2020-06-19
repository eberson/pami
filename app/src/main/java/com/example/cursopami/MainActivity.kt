package com.example.cursopami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickHere(v: View){
        //inicialmente consideramos que o campo não tem erros
        txtUsuario.error = null

        val nome = txtUsuario.text.toString()

        //TextUtils.isEmpty checa se o parametro está vazio
        //guard block
        if (TextUtils.isEmpty(nome)){
            txtUsuario.error = getString(R.string.msg_campo_obrigatorio)
            return
        }

        Toast.makeText(
            this,
            getString(R.string.msg_seja_bem_vindo_usuario, nome),
            Toast.LENGTH_SHORT
        ).show()
    }

    fun showLinearLayout(v:View){
        val intent = Intent(MainActivity@this, LinearActivity::class.java)
        startActivity(intent)
    }

    fun showRelativeLayout(v:View){
        val intent = Intent(MainActivity@this, RelativeLayout::class.java)
        startActivity(intent)
    }

    fun openCalculator(v:View){
        //a intent possui a origem e o destino da intencao
        // a origem, this, é a própria atividade onde o código sera executado
        //o destino é a classe que representa a atividade que se pretende abrir
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
}
