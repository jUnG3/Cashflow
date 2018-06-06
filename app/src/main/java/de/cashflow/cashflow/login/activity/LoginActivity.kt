package de.cashflow.cashflow.login.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.cashflow.cashflow.R
import de.cashflow.cashflow.hash.ShaHasher
import de.cashflow.cashflow.login.bl.CredentialChecker
import de.cashflow.cashflow.login.handler.LoginHandler
import de.cashflow.cashflow.login.handler.RegistrationHandler
import de.cashflow.cashflow.login.repository.MemoryUserRepository
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        const val USERNAME: String = "ARG_USERNAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val checker = CredentialChecker(ShaHasher(), usernameInputField, passwordInputField, MemoryUserRepository())

        setupLoginButton(checker)
        setupRegisterButton(checker)
    }

    private fun setupRegisterButton(checker: CredentialChecker) {
        registerButton.setOnClickListener(RegistrationHandler(checker))
    }

    private fun setupLoginButton(checker: CredentialChecker) {
        loginButton.setOnClickListener(LoginHandler(checker))
    }
}
