package br.com.etecmatao.meucursodeandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ExpensesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)
    }

    fun openNewExpense(v: View){
        val intent = Intent(this, NewExpenseActivity::class.java)
        startActivity(intent)
    }
}
