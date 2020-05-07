package br.com.etecmatao.curso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun abrirSortearNumero(v:View){
        //uma intencao no android tem dois parametro origem e destino
        //this -> representa a propria classe (MenuActivity)
        //MainActivity::class.java -> é a atividade que queremos iniciar
        var intent = Intent(this, MainActivity::class.java)

        //tente executar a minha intencao
        startActivity(intent)
    }
}
