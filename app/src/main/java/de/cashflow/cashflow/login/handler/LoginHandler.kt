package de.cashflow.cashflow.login.handler

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import de.cashflow.cashflow.R
import de.cashflow.cashflow.dashboard.activity.DashboardActivity
import de.cashflow.cashflow.login.activity.LoginActivity
import de.cashflow.cashflow.login.manager.UserManager

class LoginHandler(private val checker: UserManager) : View.OnClickListener {

    override fun onClick(v: View) {
        when (checker.checkCredentials()) {
            true -> toDashboardActivity(v.context)
            false -> Toast.makeText(v.context, R.string.label_wrong_credentials, Toast.LENGTH_SHORT).show()
        }
    }

    private fun toDashboardActivity(context: Context) {
        val intent = Intent(context, DashboardActivity::class.java)
        intent.putExtra(LoginActivity.USERNAME, checker.fetchUserName())
        context.startActivity(intent)
        (context as LoginActivity).finish()
    }

}
