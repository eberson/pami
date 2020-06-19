package com.example.cursopami.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cursopami.R


class ExpenseAdapter(private var expenses: MutableList<Expense>, private val context: Context):
    RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.expense_item, null)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        holder.bind(expense)
    }

    override fun getItemCount(): Int {
        return expenses.count()
    }

    fun update(items: MutableList<Expense>){
        items.filter { !expenses.contains(it) }.forEach { expenses.add(it) }
        notifyDataSetChanged()
    }

    class ExpenseViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private lateinit var description: TextView
        private lateinit var place: TextView
        private lateinit var value: TextView
        private var initialized: Boolean = false

        private fun init(v: View){
            description = v.findViewById(R.id.description)
            place = v.findViewById(R.id.place)
            value = v.findViewById(R.id.value)
            initialized = true
        }

        fun bind(expense: Expense){
            if (!initialized){
                init(view)
            }

            description.text = expense.description
            place.text = expense.inputSource
            value.text = expense.value.toString()
        }
    }
}