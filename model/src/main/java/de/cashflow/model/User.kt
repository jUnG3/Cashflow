package de.cashflow.model

data class User(val username: String, val password: String){
    var balance: Double = 0.0
    var incomes: List<Income> = ArrayList()
    var expenses: List<Expense> = ArrayList()
}