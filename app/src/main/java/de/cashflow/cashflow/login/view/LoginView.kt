package de.cashflow.cashflow.login.view

import de.cashflow.domain.model.User

interface LoginView {

    fun navigateToDashboard(user: User)

    fun showErrorMessage()

    fun showSuccessMessage()

    fun getUserName(): String

    fun getPassword(): String
}