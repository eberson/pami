package com.example.cursopami

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.example.cursopami.model.Expense
import com.example.cursopami.repository.ExpenseRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_new_expense.*

class NewExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_expense)
    }

    fun save(v: View){
        val fields = listOf(txtDescription, txtKind, txtSource, txtValue)

        if (fields.map { valid(it) }.filter { !it }.any()){
            return
        }

        val description = txtDescription.text.toString()
        val source = txtSource.text.toString()
        val value = txtValue.text.toString()
        val kind = txtKind.text.toString()

        ExpenseRepository.instance.add(Expense(
            description = description,
            inputSource = source,
            kind = kind,
            value = value.toDouble()
        ))

        var msg = getString(R.string.msg_expense_saved)
        msg += "\ndescription=${description}\nsource=${source}\nvalue=${value}\nkind=${kind}"

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun valid(input: TextInputEditText): Boolean {
        val result = !TextUtils.isEmpty(input.text.toString())

        input.error = if (result) null else getString(R.string.msg_required_field)

        return result
    }
}
