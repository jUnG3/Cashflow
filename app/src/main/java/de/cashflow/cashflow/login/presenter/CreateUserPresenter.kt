package de.cashflow.cashflow.login.presenter

import android.view.View
import de.cashflow.cashflow.login.view.LoginView
import de.cashflow.domain.model.User
import de.cashflow.domain.usecase.UseCase

class CreateUserPresenter(private val registerUseCase: UseCase<User, User>, private val view: LoginView) : UseCase.Callback<User> {

    override fun onSuccess(output: User) {
        view.showSuccessMessage()
    }

    override fun onError(exception: Throwable) {
        view.showErrorMessage()
    }

    fun registerButtonClick(v: View) {
        val registerUser = User(view.getUserName(), view.getPassword())
        registerUseCase.execute(registerUser, this)
    }
}