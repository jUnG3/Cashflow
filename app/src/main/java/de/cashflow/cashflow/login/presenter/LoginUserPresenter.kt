package de.cashflow.cashflow.login.presenter

import android.view.View
import de.cashflow.cashflow.login.view.LoginView
import de.cashflow.domain.model.User
import de.cashflow.domain.usecase.UseCase

class LoginUserPresenter(private val loginUseCase: UseCase<User, User>, private val view: LoginView) : UseCase.Callback<User>, View.OnClickListener {

    override fun onSuccess(output: User) {
        view.navigateToDashboard(output)
    }

    override fun onError(exception: Throwable) {
        view.showErrorMessage()
    }

    override fun onClick(v: View?) {
        val loginUser = User(view.getUserName(), view.getPassword())
        loginUseCase.execute(loginUser, this)
    }
}