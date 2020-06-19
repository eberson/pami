package com.example.cursopami.repository

import com.example.cursopami.model.Expense

class ExpenseRepository {
    private val expenses: MutableList<Expense> = mutableListOf()

    fun add(expense: Expense): ExpenseRepository{
        expenses.add(expense)
        return this
    }

    fun get(): MutableList<Expense>{
        return expenses
    }

    companion object{
        val instance: ExpenseRepository = ExpenseRepository()

    }
}