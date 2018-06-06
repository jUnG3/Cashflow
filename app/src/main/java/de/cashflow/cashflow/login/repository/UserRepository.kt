package de.cashflow.cashflow.login.repository

interface UserRepository {

    fun fetchUser(username: String): String?

    fun checkUser(username: String): Boolean

    fun saveUser(username: String, password: String)
}