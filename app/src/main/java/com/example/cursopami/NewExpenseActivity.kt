package com.example.cursopami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
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

        var msg = getString(R.string.msg_expense_saved)
        msg += "\ndescription=${description}\nsource=${source}\nvalue=${value}\nkind=${kind}"

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun valid(v: TextInputEditText): Boolean {
        v.error = null

        if (TextUtils.isEmpty(v.text.toString())){
            v.error = getString(R.string.msg_required_field)
            return false
        }

        return true
    }
}
