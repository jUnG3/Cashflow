package de.cashflow.cashflow.login.view

import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import de.cashflow.cashflow.R
import de.cashflow.cashflow.dashboard.activity.DashboardActivity
import de.cashflow.cashflow.login.activity.LoginActivity
import de.cashflow.domain.model.User

class UsernameAndPasswordView(private val usernameView: EditText, private val passwordView: EditText) : LoginView {

    override fun showErrorMessage() {
        Toast.makeText(usernameView.context, R.string.label_wrong_credentials, Toast.LENGTH_SHORT).show()
    }

    override fun showSuccessMessage() {
        Toast.makeText(usernameView.context, R.string.label_account_created, Toast.LENGTH_SHORT).show()
    }

    override fun getUserName() = usernameView.text.toString()

    override fun getPassword() = passwordView.text.toString()

    override fun navigateToDashboard(user: User) {
        val intent = Intent(usernameView.context, DashboardActivity::class.java)
        intent.putExtra(LoginActivity.USERNAME, user.username)
        usernameView.context.startActivity(intent)
        (usernameView.context as LoginActivity).finish()
    }
}