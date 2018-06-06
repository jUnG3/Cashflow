package de.cashflow.cashflow.login.repository

import de.cashflow.cashflow.login.repository.UserRepository.Result.*

class UserRepositoryImpl : UserRepository {

    companion object {
        private var users: MutableMap<String, String> = HashMap()
    }

    override fun checkUser(username: String): Boolean {
        return users.containsKey(username)
    }

    override fun saveUser(username: String, password: String) : UserRepository.Result {
        if(username.length < 3) return USERNAME_INVALID
        if(users.containsKey(username)) return USERNAME_TAKEN
        users[username] = password; return SUCCESS
    }

    override fun fetchUser(username: String): String? {
        return users[username]
    }
}