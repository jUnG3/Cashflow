package de.cashflow.cashflow.login.manager

import android.widget.EditText
import de.cashflow.cashflow.hash.Hasher
import de.cashflow.cashflow.user.repository.UserRepository

class UserManager(
        private val hasher: Hasher,
        private val usernameView: EditText,
        private val passwordView: EditText,
        private val userRepository: UserRepository
) {

    fun checkCredentials() = hashPassword(passwordView.text.toString()) == userRepository.fetchUser(usernameView.text.toString())

    fun checkUser() = userRepository.checkUser(usernameView.text.toString())

    fun hashPassword(password: String) = hasher.hash(password)

    fun saveUser() = userRepository.saveUser(usernameView.text.toString(), hashPassword(passwordView.text.toString()))

    fun fetchUserName(): String {
        return usernameView.text.toString()
    }

    fun fetchPassword(): String {
        return passwordView.text.toString()
    }
}