package com.example.cursopami

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cursopami.model.ExpenseAdapter
import com.example.cursopami.repository.ExpenseRepository
import kotlinx.android.synthetic.main.activity_expenses.*

class ExpensesActivity : AppCompatActivity() {

    lateinit var expenseAdapter: ExpenseAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //define qual o layout que deve ser utilizado na atividade
        setContentView(R.layout.activity_expenses)

        val viewManager = LinearLayoutManager(this)

        expenseAdapter = ExpenseAdapter(ExpenseRepository.instance.get(), this)

        expenses_list.apply {
            setHasFixedSize(true)

            //define como os itens das lista devem ser organizados na visualizacao
            layoutManager = viewManager
            adapter = expenseAdapter
        }
    }

    override fun onResume() {
        super.onResume()

        Toast.makeText(
            this,
            ExpenseRepository.instance.get().size.toString(),
            Toast.LENGTH_SHORT
        ).show()
    }

    fun newExpense(v: View){

        /*
        val intent = Intent(origem, destino)

        origem: this - > representa a classe atual
        destino: NewExpenseActivity::class.java -> classe que representa o destino

        */
        val intent = Intent(this, NewExpenseActivity::class.java)
        startActivityForResult(intent, 1001)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1001){
                expenseAdapter.update(ExpenseRepository.instance.get())
            }
        }
    }
}
