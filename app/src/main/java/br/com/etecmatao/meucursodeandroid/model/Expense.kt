package br.com.etecmatao.meucursodeandroid.model

import java.math.BigDecimal
import java.util.*

data class Expense(
    var id:Long?,
    var description:String,
    var date: Date,
    var value: BigDecimal
)