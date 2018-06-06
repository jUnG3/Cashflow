package de.cashflow.cashflow.login.handler

import android.util.Log
import android.view.View
import android.widget.Toast
import de.cashflow.cashflow.R
import de.cashflow.cashflow.login.bl.CredentialChecker
import java.security.NoSuchAlgorithmException

class RegistrationHandler(
        private val checker: CredentialChecker
) : View.OnClickListener {

    override fun onClick(v: View) {

        if (checker.checkUser()) {
            Toast.makeText(v.context, v.context.getString(R.string.label_username_taken), Toast.LENGTH_SHORT).show()
            return
        }

        try {
            checker.saveUser()
            Toast.makeText(v.context, v.context.getString(R.string.label_account_created), Toast.LENGTH_SHORT).show()
        } catch (e: NoSuchAlgorithmException) {
            Log.d("Error", e.message)
        }

    }
}