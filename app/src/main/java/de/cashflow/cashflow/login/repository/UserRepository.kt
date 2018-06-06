package de.cashflow.cashflow.login.repository

interface UserRepository {

    enum class Result {
        SUCCESS,
        USERNAME_TAKEN,
        USERNAME_INVALID
    }

    fun fetchUser(username: String): String?

    fun checkUser(username: String): Boolean

    fun saveUser(username: String, password: String) : Result


}