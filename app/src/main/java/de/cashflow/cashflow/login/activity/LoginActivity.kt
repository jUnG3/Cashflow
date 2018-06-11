package de.cashflow.cashflow.login.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.cashflow.cashflow.R
import de.cashflow.cashflow.login.presenter.CreateUserPresenter
import de.cashflow.cashflow.login.presenter.LoginUserPresenter
import de.cashflow.cashflow.login.view.UsernameAndPasswordView
import de.cashflow.domain.hash.ShaHasher
import de.cashflow.domain.repository.user.InMemoryUserRepository
import de.cashflow.domain.usecase.user.AddNewUserUseCase
import de.cashflow.domain.usecase.user.LoginUserUseCase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        const val USERNAME: String = "ARG_USERNAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val view = UsernameAndPasswordView(usernameInputField, passwordInputField)
        val repository = InMemoryUserRepository()
        val hasher = ShaHasher()

        val loginPresenter = LoginUserPresenter(LoginUserUseCase(repository, hasher), view)
        val registerPresenter = CreateUserPresenter(AddNewUserUseCase(repository, hasher), view)

        loginButton.setOnClickListener(loginPresenter)
        registerButton.setOnClickListener(registerPresenter)
    }
}
