package br.com.etecmatao.meucursodeandroid

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_input_demo.*

class InputDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_demo)
    }

    fun greet(v: View){
        //val para uma variavel de atribuicao unica (read only)
        //var para uma variavel que pode ter varias atribuições
        val name = txtName.text.toString()
        val response = getString(R.string.msg_greeting, name)
        txtResponse.text = response
    }
}
