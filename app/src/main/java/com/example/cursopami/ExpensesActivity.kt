package com.example.cursopami

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ExpensesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //define qual o layout que deve ser utilizado na atividade
        setContentView(R.layout.activity_expenses)
    }

    fun newExpense(v: View){
        val intent = Intent(this, NewExpenseActivity::class.java)
        startActivity(intent)
    }
}
