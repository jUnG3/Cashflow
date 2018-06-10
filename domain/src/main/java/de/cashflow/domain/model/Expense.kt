package de.cashflow.domain.model

data class Expense(val category: ExpenseCategory, val description: String, val amount: Double)