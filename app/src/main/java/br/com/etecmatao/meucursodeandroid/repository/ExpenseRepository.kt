package br.com.etecmatao.meucursodeandroid.repository

import br.com.etecmatao.meucursodeandroid.exceptions.ExpenseAlreadyExistsException
import br.com.etecmatao.meucursodeandroid.model.Expense
import java.lang.RuntimeException

class ExpenseRepository {
    private val expenses:MutableList<Expense> = mutableListOf()

    fun save(expense: Expense){
        if (expenses.filter { it == expense }.any()){
            throw ExpenseAlreadyExistsException()
        }

        expenses.add(expense)
    }

    fun get(): MutableList<Expense>{
        return expenses
    }

    companion object{
        val instance = ExpenseRepository()
    }
}