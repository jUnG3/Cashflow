package de.cashflow.cashflow.login.handler

import android.util.Log
import android.view.View
import android.widget.Toast
import de.cashflow.cashflow.R
import de.cashflow.cashflow.login.bl.CredentialChecker
import de.cashflow.cashflow.login.repository.UserRepository.Result.*
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
            val message = when(checker.saveUser()){
                SUCCESS -> R.string.label_account_created
                USERNAME_INVALID -> R.string.label_username_short
                USERNAME_TAKEN -> R.string.label_username_taken
            }
            Toast.makeText(v.context, v.context.getString(message), Toast.LENGTH_SHORT).show()
        } catch (e: NoSuchAlgorithmException) {
            Log.d("Error", e.message)
        }

    }
}