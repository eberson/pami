package br.com.etecmatao.meucursodeandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showMessage(v: View){
        //Toast é o componente que emite mensagens "simples" ao usuario
        Toast.makeText(this, getString(R.string.msg_bem_vindo), Toast.LENGTH_SHORT).show()
    }

    fun openExpenses(v :View){
        val intent = Intent(this, ExpensesActivity::class.java)
        startActivity(intent)
    }

    fun openInputDemo(v: View){
        val intent = Intent(this, InputDemoActivity::class.java)
        startActivity(intent)
    }

    fun openMaps(v:View){
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun openLottie(v:View){
        val intent = Intent(this, LottieActivity::class.java)
        startActivity(intent)
    }

    fun openNotifications(v:View){
        val intent = Intent(this, NotificationActivity::class.java)
        startActivity(intent)
    }
}
