package br.com.etecmatao.curso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickHere(v: View){
        //Random é um objeto responsável por gerar coisas aleatórias
        //.nextInt gera um número aleatório
        //21 -> selecione um número entre 0 e 20
        var numero = Random().nextInt(21)

        //Toast é um objeto responsável por apresentar mensagens "simples"
        //this -> é dono da mensagem a MainActivity é a dona dessa mensagem
        //getString(R.string.msg_resposta, numero) -> é a mensagem a ser apresentada
        //Toast.LENGTH_SHORT -> por quanto tempo eu devo mostrar?
        Toast.makeText(this, getString(R.string.msg_resposta, numero), Toast.LENGTH_SHORT).show()
    }
}
