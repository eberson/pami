package br.com.etecmatao.meucursodeandroid

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.etecmatao.meucursodeandroid.exceptions.ExpenseAlreadyExistsException
import br.com.etecmatao.meucursodeandroid.model.Expense
import br.com.etecmatao.meucursodeandroid.repository.ExpenseRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_new_expense.*
import java.math.BigDecimal
import java.text.SimpleDateFormat

class NewExpenseActivity : AppCompatActivity() {
    private val formatter = SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_expense)
    }

    fun save(v: View){
        if (!validExpense()){
            return
        }

        val description = txtDescription.text.toString()

        val dateContent = txtDate.text.toString()
        val date = formatter.parse(dateContent)

        val valueContent = txtValue.text.toString()
        val value = BigDecimal(valueContent)

        val expense = Expense(
            null,
            description,
            date,
            value
        )

        try {
            ExpenseRepository.instance.save(expense)

            Toast.makeText(
                this,
                getString(R.string.msg_save_success, description),
                Toast.LENGTH_SHORT
            ).show()

            finish()
        } catch (e: ExpenseAlreadyExistsException){
            Toast.makeText(
                this,
                getString(R.string.msg_expense_already_exists),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

//    private fun validExpense(): Boolean {
//        val description = txtDescription.text.toString()
//        val dateContent = txtDate.text.toString()
//        val valueContent = txtValue.text.toString()
//
//        txtDescription.error = null
//        txtDate.error = null
//        txtValue.error = null
//
//        var valid = true
//
//        if (TextUtils.isEmpty(description)){
//            txtDescription.error = getString(R.string.msg_field_required)
//            valid = false
//        }
//
//        if (TextUtils.isEmpty(dateContent)){
//            txtDate.error = getString(R.string.msg_field_required)
//            valid = false
//        }
//
//        if (TextUtils.isEmpty(valueContent)){
//            txtValue.error = getString(R.string.msg_field_required)
//            valid = false
//        }
//
//        return valid
//    }

    private fun validExpense(): Boolean {
        val validFunc = fun(input: TextInputEditText): Boolean{
            if (TextUtils.isEmpty(input.text.toString())){
                input.error = getString(R.string.msg_field_required)
                return false
            }

            return true
        }

        val fields = arrayOf(txtDescription, txtDate, txtValue)

        return fields.map { validFunc(it) }.all { it }
    }
}
